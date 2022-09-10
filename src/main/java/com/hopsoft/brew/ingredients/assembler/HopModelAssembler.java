package com.hopsoft.brew.ingredients.assembler;

import com.hopsoft.brew.ingredients.controller.HopController;
import com.hopsoft.brew.ingredients.domain.Hop;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class HopModelAssembler implements RepresentationModelAssembler<Hop, EntityModel<Hop>> {
    @Override
    public EntityModel<Hop> toModel(Hop hop){
        return EntityModel.of(hop,
                linkTo(methodOn(HopController.class).getOne(hop.getId())).withSelfRel(),
                linkTo(methodOn(HopController.class).getAll()).withRel("getAll"));
    }
}
