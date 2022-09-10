package com.hopsoft.brew.ingredients.controller;

import com.hopsoft.brew.ingredients.assembler.MaltModelAssembler;
import com.hopsoft.brew.ingredients.domain.Malt;
import com.hopsoft.brew.ingredients.exception.MaltNotFoundException;
import com.hopsoft.brew.ingredients.service.api.MaltService;
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
@RequestMapping("/api/ingredients/malts")
public class MaltController {
    private static final Logger logger = LoggerFactory.getLogger(MaltController.class);

    @Autowired
    MaltService maltService;

    @Autowired
    MaltModelAssembler maltModelAssembler;

    @GetMapping(value="/list")
    public @ResponseBody
    CollectionModel<EntityModel<Malt>> getAll(){
        List<EntityModel<Malt>> malts = maltService
                .findAll()
                .stream()
                .map(maltModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(malts, linkTo(methodOn(MaltController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/maltId/{id}")
    public @ResponseBody
    EntityModel<Malt> getOne(@PathVariable String id) {
        Malt malt = maltService.findByMaltId(id).orElseThrow(() -> new MaltNotFoundException(id));
        return maltModelAssembler.toModel(malt);
    }

    @PostMapping(path="/malt")
    public @ResponseBody
    ResponseEntity<?> newMalt(@RequestBody Malt newMalt){
        EntityModel<Malt> entityModel = maltModelAssembler.toModel(maltService.saveMalt(newMalt));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping(path = "/maltId/{id}")
    public @ResponseBody
    ResponseEntity<?> replaceMalt(@RequestBody Malt newMalt, @PathVariable String id){
        Malt updatedMalt = maltService.findByMaltId(id).map(malt -> {
            malt.setMaltName(newMalt.getMaltName());
            malt.setMaltType(newMalt.getMaltType());
            malt.setPercentExtractFineGrindDryBasis(newMalt.getPercentExtractFineGrindDryBasis());
            malt.setPercentExtractCoarseGrindDryBasis(newMalt.getPercentExtractCoarseGrindDryBasis());
            malt.setMealy(newMalt.getMealy());
            malt.setHalf(newMalt.getHalf());
            malt.setGlassy(newMalt.getGlassy());
            malt.setSizeSevenSixtyFourths(newMalt.getSizeSevenSixtyFourths());
            malt.setSizeFiveSixtyFourths(newMalt.getSizeFiveSixtyFourths());
            malt.setSizeSixSixtyFourths(newMalt.getSizeSixSixtyFourths());
            malt.setSizeThru(newMalt.getSizeThru());
            malt.setPercentMoisture(newMalt.getPercentMoisture());
            malt.setFineCoarseDifference(newMalt.getFineCoarseDifference());
            malt.setProtein(newMalt.getProtein());
            malt.setSolubleToTotalProteinRatio(newMalt.getSolubleToTotalProteinRatio());
            malt.setDiastaticPower(newMalt.getDiastaticPower());
            malt.setColor(newMalt.getColor());
            malt.setGrainType(newMalt.getGrainType());
            return maltService.saveMalt(malt);
        }).orElseGet(()->{
            newMalt.setId(id);
            return maltService.saveMalt(newMalt);
        });

        EntityModel<Malt> entityModel = maltModelAssembler.toModel(updatedMalt);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/maltId/{id}")
    ResponseEntity<?> deleteMalt(@PathVariable String id) {
        maltService.deleteByMaltId(id);
        return ResponseEntity.noContent().build();
    }
}
