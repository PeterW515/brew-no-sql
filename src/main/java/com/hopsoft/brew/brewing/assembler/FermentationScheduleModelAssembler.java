package com.hopsoft.brew.brewing.assembler;

import com.hopsoft.brew.brewing.controller.FermentationScheduleController;
import com.hopsoft.brew.brewing.domain.FermentationSchedule;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class FermentationScheduleModelAssembler implements RepresentationModelAssembler<FermentationSchedule, EntityModel<FermentationSchedule>> {
    @Override
    public EntityModel<FermentationSchedule> toModel(FermentationSchedule fermentationSchedule) {
        return EntityModel.of(fermentationSchedule,
                linkTo(methodOn(FermentationScheduleController.class).getOne(fermentationSchedule.getId())).withSelfRel(),
                linkTo(methodOn(FermentationScheduleController.class).getAll()).withRel("getAll"));
    }
}
