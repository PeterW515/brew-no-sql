package com.hopsoft.brew.ingredients.assembler;

import com.hopsoft.brew.ingredients.controller.WaterProfileController;
import com.hopsoft.brew.ingredients.domain.WaterProfile;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class WaterProfileModelAssembler implements RepresentationModelAssembler<WaterProfile, EntityModel<WaterProfile>> {
    @Override
    public EntityModel<WaterProfile> toModel(WaterProfile waterProfile){
        return EntityModel.of(waterProfile,
                linkTo(methodOn(WaterProfileController.class).getOne(waterProfile.getId())).withSelfRel(),
                linkTo(methodOn(WaterProfileController.class).getAll()).withRel("getAll"));
    }
}
