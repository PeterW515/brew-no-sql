package com.hopsoft.brew.ingredients.controller;

import com.hopsoft.brew.ingredients.assembler.YeastModelAssembler;
import com.hopsoft.brew.ingredients.domain.Yeast;
import com.hopsoft.brew.ingredients.exception.YeastNotFoundException;
import com.hopsoft.brew.ingredients.service.api.YeastService;
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
@RequestMapping("/api/ingredients/yeasts")
public class YeastController {
    private static final Logger logger = LoggerFactory.getLogger(YeastController.class);

    @Autowired
    YeastService yeastService;

    @Autowired
    YeastModelAssembler yeastModelAssembler;

    @GetMapping(value="/list")
    public @ResponseBody
    CollectionModel<EntityModel<Yeast>> getAll(){
        List<EntityModel<Yeast>> yeasts = yeastService
                .findAll()
                .stream()
                .map(yeastModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(yeasts, linkTo(methodOn(YeastController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/yeastId/{id}")
    public @ResponseBody
    EntityModel<Yeast> getOne(@PathVariable String id) {
        Yeast yeast = yeastService.findByYeastId(id).orElseThrow(() -> new YeastNotFoundException(id));
        return yeastModelAssembler.toModel(yeast);
    }
}
