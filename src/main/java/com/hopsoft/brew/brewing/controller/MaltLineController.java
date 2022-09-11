package com.hopsoft.brew.brewing.controller;

import com.hopsoft.brew.brewing.assembler.MaltLineModelAssembler;
import com.hopsoft.brew.brewing.domain.MaltLine;
import com.hopsoft.brew.brewing.exception.MaltLineNotFoundException;
import com.hopsoft.brew.brewing.service.api.MaltLineService;
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
@RequestMapping("/api/ingredients/maltLines")
public class MaltLineController {
    private static final Logger logger = LoggerFactory.getLogger(MaltLineController.class);

    @Autowired
    MaltLineService maltLineService;

    @Autowired
    MaltLineModelAssembler maltLineModelAssembler;

    @GetMapping(value = "/list")
    public @ResponseBody
    CollectionModel<EntityModel<MaltLine>> getAll() {
        List<EntityModel<MaltLine>> maltLines = maltLineService
                .findAll()
                .stream()
                .map(maltLineModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(maltLines, linkTo(methodOn(MaltLineController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/maltLineId/{id}")
    public @ResponseBody
    EntityModel<MaltLine> getOne(@PathVariable String id) {
        MaltLine maltLine = maltLineService.findByMaltLineId(id).orElseThrow(() -> new MaltLineNotFoundException(id));
        return maltLineModelAssembler.toModel(maltLine);
    }

    @PostMapping(path = "/maltLine")
    public @ResponseBody
    ResponseEntity<?> newMaltLine(@RequestBody MaltLine newMaltLine) {
        EntityModel<MaltLine> entityModel = maltLineModelAssembler.toModel(maltLineService.saveMaltLine(newMaltLine));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping(path = "/maltLineId/{id}")
    public @ResponseBody
    ResponseEntity<?> replaceMaltLine(@RequestBody MaltLine newMaltLine, @PathVariable String id) {
        MaltLine updatedMaltLine = maltLineService.findByMaltLineId(id).map(maltLine -> {
            maltLine.setMalt(newMaltLine.getMalt());
            maltLine.setLineNumber(newMaltLine.getLineNumber());
            maltLine.setQuantity(newMaltLine.getQuantity());
            maltLine.setId(newMaltLine.getId());
            maltLine.setUnitOfMeasure(newMaltLine.getUnitOfMeasure());
            return maltLineService.saveMaltLine(maltLine);
        }).orElseGet(() -> {
            newMaltLine.setId(id);
            return maltLineService.saveMaltLine(newMaltLine);
        });

        EntityModel<MaltLine> entityModel = maltLineModelAssembler.toModel(updatedMaltLine);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/maltLineId/{id}")
    ResponseEntity<?> deleteMaltLine(@PathVariable String id) {
        maltLineService.deleteByMaltLineId(id);
        return ResponseEntity.noContent().build();
    }
}
