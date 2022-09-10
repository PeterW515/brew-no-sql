package com.hopsoft.brew.ingredients.controller;

import com.hopsoft.brew.ingredients.assembler.HopModelAssembler;
import com.hopsoft.brew.ingredients.domain.Hop;
import com.hopsoft.brew.ingredients.exception.HopNotFoundException;
import com.hopsoft.brew.ingredients.service.api.HopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/ingredients/hops")
public class HopController {
    private static final Logger logger = LoggerFactory.getLogger(HopController.class);

    @Autowired
    HopService hopService;

    @Autowired
    HopModelAssembler hopModelAssembler;

    @GetMapping(value="/list")
    public @ResponseBody
    CollectionModel<EntityModel<Hop>> getAll(){
        List<EntityModel<Hop>> hops = hopService
                .findAll()
                .stream()
                .map(hopModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(hops, linkTo(methodOn(HopController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/hop/{id}")
    public @ResponseBody
    EntityModel<Hop> getOne(@PathVariable String id) {
        Hop hop = hopService.findByHopId(id).orElseThrow(() -> new HopNotFoundException(id));
        return hopModelAssembler.toModel(hop);
    }
}
