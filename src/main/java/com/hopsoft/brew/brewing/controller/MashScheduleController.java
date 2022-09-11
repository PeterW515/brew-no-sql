package com.hopsoft.brew.brewing.controller;

import com.hopsoft.brew.brewing.assembler.MashScheduleModelAssembler;
import com.hopsoft.brew.brewing.domain.MashSchedule;
import com.hopsoft.brew.brewing.exception.MashScheduleNotFoundException;
import com.hopsoft.brew.brewing.service.api.MashScheduleService;
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
@RequestMapping("/api/ingredients/mashSchedules")
public class MashScheduleController {
    private static final Logger logger = LoggerFactory.getLogger(MashScheduleController.class);

    @Autowired
    MashScheduleService mashScheduleService;

    @Autowired
    MashScheduleModelAssembler mashScheduleModelAssembler;

    @GetMapping(value = "/list")
    public @ResponseBody
    CollectionModel<EntityModel<MashSchedule>> getAll() {
        List<EntityModel<MashSchedule>> mashSchedules = mashScheduleService
                .findAll()
                .stream()
                .map(mashScheduleModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(mashSchedules, linkTo(methodOn(MashScheduleController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/mashScheduleId/{id}")
    public @ResponseBody
    EntityModel<MashSchedule> getOne(@PathVariable String id) {
        MashSchedule mashSchedule = mashScheduleService.findByMashScheduleId(id).orElseThrow(() -> new MashScheduleNotFoundException(id));
        return mashScheduleModelAssembler.toModel(mashSchedule);
    }

    @PostMapping(path = "/mashSchedule")
    public @ResponseBody
    ResponseEntity<?> newMashSchedule(@RequestBody MashSchedule newMashSchedule) {
        EntityModel<MashSchedule> entityModel = mashScheduleModelAssembler.toModel(mashScheduleService.saveMashSchedule(newMashSchedule));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping(path = "/mashScheduleId/{id}")
    public @ResponseBody
    ResponseEntity<?> replaceMashSchedule(@RequestBody MashSchedule newMashSchedule, @PathVariable String id) {
        MashSchedule updatedMashSchedule = mashScheduleService.findByMashScheduleId(id).map(mashSchedule -> {
            mashSchedule.setMashRests(newMashSchedule.getMashRests());
            mashSchedule.setId(newMashSchedule.getId());
            mashSchedule.setInfusionType(newMashSchedule.getInfusionType());
            return mashScheduleService.saveMashSchedule(mashSchedule);
        }).orElseGet(() -> {
            newMashSchedule.setId(id);
            return mashScheduleService.saveMashSchedule(newMashSchedule);
        });

        EntityModel<MashSchedule> entityModel = mashScheduleModelAssembler.toModel(updatedMashSchedule);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/mashScheduleId/{id}")
    ResponseEntity<?> deleteMashSchedule(@PathVariable String id) {
        mashScheduleService.deleteByMashScheduleId(id);
        return ResponseEntity.noContent().build();
    }
}
