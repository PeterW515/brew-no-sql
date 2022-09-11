package com.hopsoft.brew.brewing.controller;

import com.hopsoft.brew.brewing.assembler.FermentationScheduleModelAssembler;
import com.hopsoft.brew.brewing.domain.FermentationSchedule;
import com.hopsoft.brew.brewing.exception.FermentationScheduleNotFoundException;
import com.hopsoft.brew.brewing.service.api.FermentationScheduleService;
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
@RequestMapping("/api/brewing/fermentationSchedules")
public class FermentationScheduleController {
    private static final Logger logger = LoggerFactory.getLogger(FermentationScheduleController.class);

    @Autowired
    FermentationScheduleService fermentationScheduleService;

    @Autowired
    FermentationScheduleModelAssembler fermentationScheduleModelAssembler;

    @GetMapping(value = "/list")
    public @ResponseBody
    CollectionModel<EntityModel<FermentationSchedule>> getAll() {
        List<EntityModel<FermentationSchedule>> fermentationSchedules = fermentationScheduleService
                .findAll()
                .stream()
                .map(fermentationScheduleModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(fermentationSchedules, linkTo(methodOn(FermentationScheduleController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/fermentationScheduleId/{id}")
    public @ResponseBody
    EntityModel<FermentationSchedule> getOne(@PathVariable String id) {
        FermentationSchedule fermentationSchedule = fermentationScheduleService.findByFermentationScheduleId(id).orElseThrow(() -> new FermentationScheduleNotFoundException(id));
        return fermentationScheduleModelAssembler.toModel(fermentationSchedule);
    }

    @PostMapping(path = "/fermentationSchedule")
    public @ResponseBody
    ResponseEntity<?> newFermentationSchedule(@RequestBody FermentationSchedule newFermentationSchedule) {
        EntityModel<FermentationSchedule> entityModel = fermentationScheduleModelAssembler.toModel(fermentationScheduleService.saveFermentationSchedule(newFermentationSchedule));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping(path = "/fermentationScheduleId/{id}")
    public @ResponseBody
    ResponseEntity<?> replaceFermentationSchedule(@RequestBody FermentationSchedule newFermentationSchedule, @PathVariable String id) {
        FermentationSchedule updatedFermentationSchedule = fermentationScheduleService.findByFermentationScheduleId(id).map(fermentationSchedule -> {
            fermentationSchedule.setId(newFermentationSchedule.getId());
            fermentationSchedule.setMaxTemp(newFermentationSchedule.getMaxTemp());
            fermentationSchedule.setMinTemp(newFermentationSchedule.getMinTemp());
            fermentationSchedule.setNominalTemp(newFermentationSchedule.getNominalTemp());
            fermentationSchedule.setStage(newFermentationSchedule.getStage());
            fermentationSchedule.setNumDays(newFermentationSchedule.getNumDays());
            return fermentationScheduleService.saveFermentationSchedule(fermentationSchedule);
        }).orElseGet(() -> {
            newFermentationSchedule.setId(id);
            return fermentationScheduleService.saveFermentationSchedule(newFermentationSchedule);
        });

        EntityModel<FermentationSchedule> entityModel = fermentationScheduleModelAssembler.toModel(updatedFermentationSchedule);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/fermentationScheduleId/{id}")
    ResponseEntity<?> deleteFermentationSchedule(@PathVariable String id) {
        fermentationScheduleService.deleteByFermentationScheduleId(id);
        return ResponseEntity.noContent().build();
    }
}
