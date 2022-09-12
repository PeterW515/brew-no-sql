package com.hopsoft.brew.brewing.assembler;

import com.hopsoft.brew.brewing.controller.BrewingRunController;
import com.hopsoft.brew.brewing.domain.BrewingRun;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BrewingRunModelAssembler implements RepresentationModelAssembler<BrewingRun, EntityModel<BrewingRun>> {
    @Override
    public EntityModel<BrewingRun> toModel(BrewingRun brewingRun) {
        return EntityModel.of(brewingRun,
                linkTo(methodOn(BrewingRunController.class).getOne(brewingRun.getId())).withSelfRel(),
                linkTo(methodOn(BrewingRunController.class).getAll()).withRel("getAll"));
    }
}
