package com.hopsoft.brew.ingredients.assembler;

import com.hopsoft.brew.ingredients.controller.MaltController;
import com.hopsoft.brew.ingredients.domain.Malt;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MaltModelAssembler implements RepresentationModelAssembler<Malt, EntityModel<Malt>> {
    @Override
    public EntityModel<Malt> toModel(Malt malt){
        return EntityModel.of(malt,
                linkTo(methodOn(MaltController.class).getOne(malt.getId())).withSelfRel(),
                linkTo(methodOn(MaltController.class).getAll()).withRel("getAll"));
    }
}
