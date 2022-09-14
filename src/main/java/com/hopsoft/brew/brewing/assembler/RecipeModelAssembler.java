package com.hopsoft.brew.brewing.assembler;

import com.hopsoft.brew.brewing.controller.*;
import com.hopsoft.brew.brewing.domain.HopLine;
import com.hopsoft.brew.brewing.domain.MaltLine;
import com.hopsoft.brew.brewing.domain.Recipe;
import com.hopsoft.brew.brewing.domain.YeastLine;
import com.hopsoft.brew.ingredients.controller.WaterProfileController;
import com.hopsoft.brew.ingredients.domain.Yeast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RecipeModelAssembler implements RepresentationModelAssembler<Recipe, EntityModel<Recipe>> {
    private static final Logger logger = LoggerFactory.getLogger(RecipeModelAssembler.class);
    @Override
    public EntityModel<Recipe> toModel(Recipe recipe) {

        logger.info("recipe" + recipe);

        EntityModel<Recipe> entityModel =  EntityModel.of(recipe,
                linkTo(methodOn(RecipeController.class).getOne(recipe.getId())).withSelfRel(),
                linkTo(methodOn(RecipeController.class).getAll()).withRel("getAll"));

        //add link for water profile and mash schedule
        entityModel.add(linkTo(methodOn(WaterProfileController.class).getOne(recipe.getWaterProfile().getId())).withRel("waterProfile"));
        entityModel.add(linkTo(methodOn(MashScheduleController.class).getOne(recipe.getMashSchedule().getId())).withRel("mashSchedule"));

        //add links for lines
        for(HopLine hopLine : recipe.getHopLines()){
            entityModel.add(linkTo(methodOn(HopLineController.class).getOne(hopLine.getId())).withRel("hopLines"));
        }
        for(MaltLine maltLine : recipe.getMaltLines()){
            entityModel.add(linkTo(methodOn(MaltLineController.class).getOne(maltLine.getId())).withRel("maltLines"));
        }
        for(YeastLine yeastLine : recipe.getYeastLines()){
            entityModel.add(linkTo(methodOn(YeastLineController.class).getOne(yeastLine.getId())).withRel("yeastLines"));
        }

        logger.info("entityModel" + entityModel);

        return entityModel;
    }
}
