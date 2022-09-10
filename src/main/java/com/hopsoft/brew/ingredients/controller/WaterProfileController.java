package com.hopsoft.brew.ingredients.controller;

import com.hopsoft.brew.ingredients.assembler.WaterProfileModelAssembler;
import com.hopsoft.brew.ingredients.domain.WaterProfile;
import com.hopsoft.brew.ingredients.exception.WaterProfileNotFoundException;
import com.hopsoft.brew.ingredients.service.api.WaterProfileService;
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
@RequestMapping("/api/ingredients/waterProfiles")
public class WaterProfileController {
    private static final Logger logger = LoggerFactory.getLogger(WaterProfileController.class);

    @Autowired
    WaterProfileService waterProfileService;

    @Autowired
    WaterProfileModelAssembler waterProfileModelAssembler;

    @GetMapping(value="/list")
    public @ResponseBody
    CollectionModel<EntityModel<WaterProfile>> getAll(){
        List<EntityModel<WaterProfile>> waterProfiles = waterProfileService
                .findAll()
                .stream()
                .map(waterProfileModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(waterProfiles, linkTo(methodOn(WaterProfileController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/waterProfileId/{id}")
    public @ResponseBody
    EntityModel<WaterProfile> getOne(@PathVariable String id) {
        WaterProfile waterProfile = waterProfileService.findByWaterProfileId(id).orElseThrow(() -> new WaterProfileNotFoundException(id));
        return waterProfileModelAssembler.toModel(waterProfile);
    }

    @PostMapping(path="/waterProfile")
    public @ResponseBody
    ResponseEntity<?> newWaterProfile(@RequestBody WaterProfile newWaterProfile){
        EntityModel<WaterProfile> entityModel = waterProfileModelAssembler.toModel(waterProfileService.saveWaterProfile(newWaterProfile));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping(path = "/waterProfileId/{id}")
    public @ResponseBody
    ResponseEntity<?> replaceWaterProfile(@RequestBody WaterProfile newWaterProfile, @PathVariable String id){
        WaterProfile updatedWaterProfile = waterProfileService.findByWaterProfileId(id).map(waterProfile -> {
            waterProfile.setWaterProfileName(newWaterProfile.getWaterProfileName());
            waterProfile.setCalciumPPM(newWaterProfile.getCalciumPPM());
            waterProfile.setMagnesiumPPM(newWaterProfile.getMagnesiumPPM());
            waterProfile.setBicarbonatePPM(newWaterProfile.getBicarbonatePPM());
            waterProfile.setSulfatePPM(newWaterProfile.getSulfatePPM());
            waterProfile.setSodiumPPM(newWaterProfile.getSodiumPPM());
            waterProfile.setChloridePPM(newWaterProfile.getChloridePPM());
            waterProfile.setpH(newWaterProfile.getpH());
            return waterProfileService.saveWaterProfile(waterProfile);
        }).orElseGet(()->{
            newWaterProfile.setId(id);
            return waterProfileService.saveWaterProfile(newWaterProfile);
        });

        EntityModel<WaterProfile> entityModel = waterProfileModelAssembler.toModel(updatedWaterProfile);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/waterProfileId/{id}")
    ResponseEntity<?> deleteWaterProfile(@PathVariable String id) {
        waterProfileService.deleteByWaterProfileId(id);
        return ResponseEntity.noContent().build();
    }
}
