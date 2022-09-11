package com.hopsoft.brew.brewing.assembler;

import com.hopsoft.brew.brewing.controller.MashRestController;
import com.hopsoft.brew.brewing.domain.MashRest;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MashRestModelAssembler implements RepresentationModelAssembler<MashRest, EntityModel<MashRest>> {
    @Override
    public EntityModel<MashRest> toModel(MashRest mashRest) {
        return EntityModel.of(mashRest,
                linkTo(methodOn(MashRestController.class).getOne(mashRest.getId())).withSelfRel(),
                linkTo(methodOn(MashRestController.class).getAll()).withRel("getAll"));
    }
}
