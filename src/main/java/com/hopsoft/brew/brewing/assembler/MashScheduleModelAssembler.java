package com.hopsoft.brew.brewing.assembler;

import com.hopsoft.brew.brewing.controller.MashScheduleController;
import com.hopsoft.brew.brewing.domain.MashSchedule;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MashScheduleModelAssembler implements RepresentationModelAssembler<MashSchedule, EntityModel<MashSchedule>> {
    @Override
    public EntityModel<MashSchedule> toModel(MashSchedule mashSchedule) {
        return EntityModel.of(mashSchedule,
                linkTo(methodOn(MashScheduleController.class).getOne(mashSchedule.getId())).withSelfRel(),
                linkTo(methodOn(MashScheduleController.class).getAll()).withRel("getAll"));
    }
}
