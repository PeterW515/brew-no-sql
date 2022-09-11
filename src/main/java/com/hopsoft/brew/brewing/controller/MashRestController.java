package com.hopsoft.brew.brewing.controller;

import com.hopsoft.brew.brewing.assembler.MashRestModelAssembler;
import com.hopsoft.brew.brewing.domain.MashRest;
import com.hopsoft.brew.brewing.exception.MashRestNotFoundException;
import com.hopsoft.brew.brewing.service.api.MashRestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/brewing/mashRests")
public class MashRestController {
    private static final Logger logger = LoggerFactory.getLogger(MashRestController.class);

    @Autowired
    MashRestService mashRestService;

    @Autowired
    MashRestModelAssembler mashRestModelAssembler;

    @GetMapping(value = "/list")
    public @ResponseBody
    CollectionModel<EntityModel<MashRest>> getAll() {
        List<EntityModel<MashRest>> mashRests = mashRestService
                .findAll()
                .stream()
                .map(mashRestModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(mashRests, linkTo(methodOn(MashRestController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/mashRestId/{id}")
    public @ResponseBody
    EntityModel<MashRest> getOne(@PathVariable String id) {
        MashRest mashRest = mashRestService.findByMashRestId(id).orElseThrow(() -> new MashRestNotFoundException(id));
        return mashRestModelAssembler.toModel(mashRest);
    }

    @PostMapping(path = "/mashRest")
    public @ResponseBody
    ResponseEntity<?> newMashRest(@RequestBody MashRest newMashRest) {
        EntityModel<MashRest> entityModel = mashRestModelAssembler.toModel(mashRestService.saveMashRest(newMashRest));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping(path = "/mashRestId/{id}")
    public @ResponseBody
    ResponseEntity<?> replaceMashRest(@RequestBody MashRest newMashRest, @PathVariable String id) {
        MashRest updatedMashRest = mashRestService.findByMashRestId(id).map(mashRest -> {
            mashRest.setRestType(newMashRest.getRestType());
            mashRest.setDuration(newMashRest.getDuration());
            mashRest.setTemperature(newMashRest.getTemperature());
            mashRest.setId(newMashRest.getId());
            return mashRestService.saveMashRest(mashRest);
        }).orElseGet(() -> {
            newMashRest.setId(id);
            return mashRestService.saveMashRest(newMashRest);
        });

        EntityModel<MashRest> entityModel = mashRestModelAssembler.toModel(updatedMashRest);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/mashRestId/{id}")
    ResponseEntity<?> deleteMashRest(@PathVariable String id) {
        mashRestService.deleteByMashRestId(id);
        return ResponseEntity.noContent().build();
    }
}
