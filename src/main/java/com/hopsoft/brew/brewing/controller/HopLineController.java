package com.hopsoft.brew.brewing.controller;

import com.hopsoft.brew.brewing.assembler.HopLineModelAssembler;
import com.hopsoft.brew.brewing.domain.HopLine;
import com.hopsoft.brew.brewing.exception.HopLineNotFoundException;
import com.hopsoft.brew.brewing.service.api.HopLineService;
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
@RequestMapping("/api/ingredients/hopLines")
public class HopLineController {
    private static final Logger logger = LoggerFactory.getLogger(HopLineController.class);

    @Autowired
    HopLineService hopLineService;

    @Autowired
    HopLineModelAssembler hopLineModelAssembler;

    @GetMapping(value = "/list")
    public @ResponseBody
    CollectionModel<EntityModel<HopLine>> getAll() {
        List<EntityModel<HopLine>> hopLines = hopLineService
                .findAll()
                .stream()
                .map(hopLineModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(hopLines, linkTo(methodOn(HopLineController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/hopLineId/{id}")
    public @ResponseBody
    EntityModel<HopLine> getOne(@PathVariable String id) {
        HopLine hopLine = hopLineService.findByHopLineId(id).orElseThrow(() -> new HopLineNotFoundException(id));
        return hopLineModelAssembler.toModel(hopLine);
    }

    @PostMapping(path = "/hopLine")
    public @ResponseBody
    ResponseEntity<?> newHopLine(@RequestBody HopLine newHopLine) {
        EntityModel<HopLine> entityModel = hopLineModelAssembler.toModel(hopLineService.saveHopLine(newHopLine));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping(path = "/hopLineId/{id}")
    public @ResponseBody
    ResponseEntity<?> replaceHopLine(@RequestBody HopLine newHopLine, @PathVariable String id) {
        HopLine updatedHopLine = hopLineService.findByHopLineId(id).map(hopLine -> {
            hopLine.setId(newHopLine.getId());
            hopLine.setLineNumber(newHopLine.getLineNumber());
            hopLine.setHop(newHopLine.getHop());
            hopLine.setBoilTime(newHopLine.getBoilTime());
            hopLine.setUnitOfMeasure(newHopLine.getUnitOfMeasure());
            hopLine.setQuantity(newHopLine.getQuantity());
            hopLine.setInternationalBitternessUnits(newHopLine.getInternationalBitternessUnits());
            return hopLineService.saveHopLine(hopLine);
        }).orElseGet(() -> {
            newHopLine.setId(id);
            return hopLineService.saveHopLine(newHopLine);
        });

        EntityModel<HopLine> entityModel = hopLineModelAssembler.toModel(updatedHopLine);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/hopLineId/{id}")
    ResponseEntity<?> deleteHopLine(@PathVariable String id) {
        hopLineService.deleteByHopLineId(id);
        return ResponseEntity.noContent().build();
    }
}
