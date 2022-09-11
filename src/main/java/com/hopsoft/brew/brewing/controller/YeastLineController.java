package com.hopsoft.brew.brewing.controller;

import com.hopsoft.brew.brewing.assembler.YeastLineModelAssembler;
import com.hopsoft.brew.brewing.domain.YeastLine;
import com.hopsoft.brew.brewing.exception.YeastLineNotFoundException;
import com.hopsoft.brew.brewing.service.api.YeastLineService;
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
@RequestMapping("/api/brewing/yeastLines")
public class YeastLineController {
    private static final Logger logger = LoggerFactory.getLogger(YeastLineController.class);

    @Autowired
    YeastLineService yeastLineService;

    @Autowired
    YeastLineModelAssembler yeastLineModelAssembler;

    @GetMapping(value = "/list")
    public @ResponseBody
    CollectionModel<EntityModel<YeastLine>> getAll() {
        List<EntityModel<YeastLine>> yeastLines = yeastLineService
                .findAll()
                .stream()
                .map(yeastLineModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(yeastLines, linkTo(methodOn(YeastLineController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/yeastLineId/{id}")
    public @ResponseBody
    EntityModel<YeastLine> getOne(@PathVariable String id) {
        YeastLine yeastLine = yeastLineService.findByYeastLineId(id).orElseThrow(() -> new YeastLineNotFoundException(id));
        return yeastLineModelAssembler.toModel(yeastLine);
    }

    @PostMapping(path = "/yeastLine")
    public @ResponseBody
    ResponseEntity<?> newYeastLine(@RequestBody YeastLine newYeastLine) {
        EntityModel<YeastLine> entityModel = yeastLineModelAssembler.toModel(yeastLineService.saveYeastLine(newYeastLine));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping(path = "/yeastLineId/{id}")
    public @ResponseBody
    ResponseEntity<?> replaceYeastLine(@RequestBody YeastLine newYeastLine, @PathVariable String id) {
        YeastLine updatedYeastLine = yeastLineService.findByYeastLineId(id).map(yeastLine -> {
            yeastLine.setYeast(newYeastLine.getYeast());
            yeastLine.setLineNumber(newYeastLine.getLineNumber());
            yeastLine.setId(newYeastLine.getId());
            yeastLine.setQuantity(newYeastLine.getQuantity());
            yeastLine.setUnitOfMeasure(newYeastLine.getUnitOfMeasure());
            yeastLine.setFermentationSchedule(newYeastLine.getFermentationSchedule());
            return yeastLineService.saveYeastLine(yeastLine);
        }).orElseGet(() -> {
            newYeastLine.setId(id);
            return yeastLineService.saveYeastLine(newYeastLine);
        });

        EntityModel<YeastLine> entityModel = yeastLineModelAssembler.toModel(updatedYeastLine);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/yeastLineId/{id}")
    ResponseEntity<?> deleteYeastLine(@PathVariable String id) {
        yeastLineService.deleteByYeastLineId(id);
        return ResponseEntity.noContent().build();
    }
}
