package com.hopsoft.brew.ingredients.assembler;

import com.hopsoft.brew.ingredients.controller.YeastController;
import com.hopsoft.brew.ingredients.domain.Yeast;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class YeastModelAssembler implements RepresentationModelAssembler<Yeast, EntityModel<Yeast>> {
    @Override
    public EntityModel<Yeast> toModel(Yeast yeast){
        return EntityModel.of(yeast,
                linkTo(methodOn(YeastController.class).getOne(yeast.getId())).withSelfRel(),
                linkTo(methodOn(YeastController.class).getAll()).withRel("getAll"));
    }
}
