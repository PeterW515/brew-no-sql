package com.hopsoft.brew.brewing.assembler;

import com.hopsoft.brew.brewing.controller.HopLineController;
import com.hopsoft.brew.brewing.domain.HopLine;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class HopLineModelAssembler implements RepresentationModelAssembler<HopLine, EntityModel<HopLine>> {
    @Override
    public EntityModel<HopLine> toModel(HopLine hopLine) {
        return EntityModel.of(hopLine,
                linkTo(methodOn(HopLineController.class).getOne(hopLine.getId())).withSelfRel(),
                linkTo(methodOn(HopLineController.class).getAll()).withRel("getAll"));
    }
}
