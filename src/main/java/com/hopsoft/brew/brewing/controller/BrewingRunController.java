package com.hopsoft.brew.brewing.controller;

import com.hopsoft.brew.brewing.assembler.BrewingRunModelAssembler;
import com.hopsoft.brew.brewing.domain.BrewingRun;
import com.hopsoft.brew.brewing.exception.BrewingRunNotFoundException;
import com.hopsoft.brew.brewing.service.api.BrewingRunService;
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
@RequestMapping("/api/ingredients/brewingRuns")
public class BrewingRunController {
    private static final Logger logger = LoggerFactory.getLogger(BrewingRunController.class);

    @Autowired
    BrewingRunService brewingRunService;

    @Autowired
    BrewingRunModelAssembler brewingRunModelAssembler;

    @GetMapping(value = "/list")
    public @ResponseBody
    CollectionModel<EntityModel<BrewingRun>> getAll() {
        List<EntityModel<BrewingRun>> brewingRuns = brewingRunService
                .findAll()
                .stream()
                .map(brewingRunModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(brewingRuns, linkTo(methodOn(BrewingRunController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/brewingRunId/{id}")
    public @ResponseBody
    EntityModel<BrewingRun> getOne(@PathVariable String id) {
        BrewingRun brewingRun = brewingRunService.findByBrewingRunId(id).orElseThrow(() -> new BrewingRunNotFoundException(id));
        return brewingRunModelAssembler.toModel(brewingRun);
    }

    @PostMapping(path = "/brewingRun")
    public @ResponseBody
    ResponseEntity<?> newBrewingRun(@RequestBody BrewingRun newBrewingRun) {
        EntityModel<BrewingRun> entityModel = brewingRunModelAssembler.toModel(brewingRunService.saveBrewingRun(newBrewingRun));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping(path = "/brewingRunId/{id}")
    public @ResponseBody
    ResponseEntity<?> replaceBrewingRun(@RequestBody BrewingRun newBrewingRun, @PathVariable String id) {
        BrewingRun updatedBrewingRun = brewingRunService.findByBrewingRunId(id).map(brewingRun -> {
            brewingRun.setId(newBrewingRun.getId());
            brewingRun.setRunName(newBrewingRun.getRunName());
            brewingRun.setRecipe(newBrewingRun.getRecipe());
            brewingRun.setStartTime(newBrewingRun.getStartTime());
            brewingRun.setEndTime(newBrewingRun.getEndTime());
            brewingRun.setStatus(newBrewingRun.getStatus());
            return brewingRunService.saveBrewingRun(brewingRun);
        }).orElseGet(() -> {
            newBrewingRun.setId(id);
            return brewingRunService.saveBrewingRun(newBrewingRun);
        });

        EntityModel<BrewingRun> entityModel = brewingRunModelAssembler.toModel(updatedBrewingRun);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/brewingRunId/{id}")
    ResponseEntity<?> deleteBrewingRun(@PathVariable String id) {
        brewingRunService.deleteByBrewingRunId(id);
        return ResponseEntity.noContent().build();
    }
}
