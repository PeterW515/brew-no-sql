package com.hopsoft.brew.brewing.controller;

import com.hopsoft.brew.brewing.assembler.UnitOfMeasureModelAssembler;
import com.hopsoft.brew.brewing.domain.UnitOfMeasure;
import com.hopsoft.brew.brewing.exception.UnitOfMeasureNotFoundException;
import com.hopsoft.brew.brewing.service.api.UnitOfMeasureService;
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
@RequestMapping("/api/ingredients/unitsOfMeasure")
public class UnitOfMeasureController {
    private static final Logger logger = LoggerFactory.getLogger(UnitOfMeasureController.class);

    @Autowired
    UnitOfMeasureService unitOfMeasureService;

    @Autowired
    UnitOfMeasureModelAssembler unitOfMeasureModelAssembler;

    @GetMapping(value = "/list")
    public @ResponseBody
    CollectionModel<EntityModel<UnitOfMeasure>> getAll() {
        List<EntityModel<UnitOfMeasure>> unitsOfMeasure = unitOfMeasureService
                .findAll()
                .stream()
                .map(unitOfMeasureModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(unitsOfMeasure, linkTo(methodOn(UnitOfMeasureController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/unitOfMeasureId/{id}")
    public @ResponseBody
    EntityModel<UnitOfMeasure> getOne(@PathVariable String id) {
        UnitOfMeasure unitOfMeasure = unitOfMeasureService.findByUnitOfMeasureId(id).orElseThrow(() -> new UnitOfMeasureNotFoundException(id));
        return unitOfMeasureModelAssembler.toModel(unitOfMeasure);
    }

    @PostMapping(path = "/unitOfMeasure")
    public @ResponseBody
    ResponseEntity<?> newUnitOfMeasure(@RequestBody UnitOfMeasure newUnitOfMeasure) {
        EntityModel<UnitOfMeasure> entityModel = unitOfMeasureModelAssembler.toModel(unitOfMeasureService.saveUnitOfMeasure(newUnitOfMeasure));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping(path = "/unitOfMeasureId/{id}")
    public @ResponseBody
    ResponseEntity<?> replaceUnitOfMeasure(@RequestBody UnitOfMeasure newUnitOfMeasure, @PathVariable String id) {
        UnitOfMeasure updatedUnitOfMeasure = unitOfMeasureService.findByUnitOfMeasureId(id).map(unitOfMeasure -> {
            unitOfMeasure.setId(newUnitOfMeasure.getId());
            unitOfMeasure.setName(newUnitOfMeasure.getName());
            return unitOfMeasureService.saveUnitOfMeasure(unitOfMeasure);
        }).orElseGet(() -> {
            newUnitOfMeasure.setId(id);
            return unitOfMeasureService.saveUnitOfMeasure(newUnitOfMeasure);
        });

        EntityModel<UnitOfMeasure> entityModel = unitOfMeasureModelAssembler.toModel(updatedUnitOfMeasure);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/unitOfMeasureId/{id}")
    ResponseEntity<?> deleteUnitOfMeasure(@PathVariable String id) {
        unitOfMeasureService.deleteByUnitOfMeasureId(id);
        return ResponseEntity.noContent().build();
    }
}
