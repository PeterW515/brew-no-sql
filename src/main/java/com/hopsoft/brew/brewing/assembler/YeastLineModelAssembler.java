package com.hopsoft.brew.brewing.assembler;

import com.hopsoft.brew.brewing.controller.YeastLineController;
import com.hopsoft.brew.brewing.domain.YeastLine;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class YeastLineModelAssembler implements RepresentationModelAssembler<YeastLine, EntityModel<YeastLine>> {
    @Override
    public EntityModel<YeastLine> toModel(YeastLine yeastLine) {
        return EntityModel.of(yeastLine,
                linkTo(methodOn(YeastLineController.class).getOne(yeastLine.getId())).withSelfRel(),
                linkTo(methodOn(YeastLineController.class).getAll()).withRel("getAll"));
    }
}
