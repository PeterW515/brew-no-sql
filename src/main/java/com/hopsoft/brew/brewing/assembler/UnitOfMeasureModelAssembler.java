package com.hopsoft.brew.brewing.assembler;

import com.hopsoft.brew.brewing.controller.UnitOfMeasureController;
import com.hopsoft.brew.brewing.domain.UnitOfMeasure;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UnitOfMeasureModelAssembler implements RepresentationModelAssembler<UnitOfMeasure, EntityModel<UnitOfMeasure>> {
    @Override
    public EntityModel<UnitOfMeasure> toModel(UnitOfMeasure unitOfMeasure) {
        return EntityModel.of(unitOfMeasure,
                linkTo(methodOn(UnitOfMeasureController.class).getOne(unitOfMeasure.getId())).withSelfRel(),
                linkTo(methodOn(UnitOfMeasureController.class).getAll()).withRel("getAll"));
    }
}
