package com.hopsoft.brew.brewing.assembler;

import com.hopsoft.brew.brewing.controller.MaltLineController;
import com.hopsoft.brew.brewing.domain.MaltLine;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MaltLineModelAssembler implements RepresentationModelAssembler<MaltLine, EntityModel<MaltLine>> {
    @Override
    public EntityModel<MaltLine> toModel(MaltLine maltLine) {
        return EntityModel.of(maltLine,
                linkTo(methodOn(MaltLineController.class).getOne(maltLine.getId())).withSelfRel(),
                linkTo(methodOn(MaltLineController.class).getAll()).withRel("getAll"));
    }
}
