package com.hopsoft.brew.brewing.controller;

import com.hopsoft.brew.brewing.assembler.RecipeModelAssembler;
import com.hopsoft.brew.brewing.domain.Recipe;
import com.hopsoft.brew.brewing.exception.RecipeNotFoundException;
import com.hopsoft.brew.brewing.service.api.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/brewing/recipes")
public class RecipeController {
    private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeModelAssembler recipeModelAssembler;

    @GetMapping(value = "/list")
    public @ResponseBody
    CollectionModel<EntityModel<Recipe>> getAll() {
        List<EntityModel<Recipe>> recipes = recipeService
                .findAll()
                .stream()
                .map(recipeModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(recipes, linkTo(methodOn(RecipeController.class).getAll()).withSelfRel());
    }

    @GetMapping(path = "/recipeId/{id}")
    public @ResponseBody
    EntityModel<Recipe> getOne(@PathVariable String id) {
        Recipe recipe = recipeService.findByRecipeId(id).orElseThrow(() -> new RecipeNotFoundException(id));
        return recipeModelAssembler.toModel(recipe);
    }

    @PostMapping(path = "/recipe")
    public @ResponseBody
    ResponseEntity<?> newRecipe(@RequestBody Recipe newRecipe) {
        EntityModel<Recipe> entityModel = recipeModelAssembler.toModel(recipeService.saveRecipe(newRecipe));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping(path = "/recipeId/{id}")
    public @ResponseBody
    ResponseEntity<?> replaceRecipe(@RequestBody Recipe newRecipe, @PathVariable String id) {
        Recipe updatedRecipe = recipeService.findByRecipeId(id).map(recipe -> {
            recipe.setId(newRecipe.getId());
            recipe.setRecipeName(newRecipe.getRecipeName());
            recipe.setRecipeStyle(newRecipe.getRecipeStyle());
            recipe.setOriginalGravityUpperBound(newRecipe.getOriginalGravityUpperBound());
            recipe.setOriginalGravityLowerBound(newRecipe.getOriginalGravityLowerBound());
            recipe.setNominalOriginalGravity(newRecipe.getNominalOriginalGravity());
            recipe.setDegreesPlatoUpperBound(newRecipe.getDegreesPlatoUpperBound());
            recipe.setDegreesPlatoLowerBound(newRecipe.getDegreesPlatoLowerBound());
            recipe.setNominalDegreesPlato(newRecipe.getNominalDegreesPlato());
            recipe.setFinalGravityUpperBound(newRecipe.getFinalGravityUpperBound());
            recipe.setFinalGravityLowerBound(newRecipe.getFinalGravityLowerBound());
            recipe.setNominalFinalGravity(newRecipe.getNominalFinalGravity());
            recipe.setLowerBoundIBUs(newRecipe.getLowerBoundIBUs());
            recipe.setUpperBoundIBUs(newRecipe.getUpperBoundIBUs());
            recipe.setNominalIBUs(newRecipe.getNominalIBUs());
            recipe.setNominalColor(newRecipe.getNominalColor());
            recipe.setColorUpperBound(newRecipe.getColorUpperBound());
            recipe.setColorLowerBound(newRecipe.getColorLowerBound());
            recipe.setMaltLines(newRecipe.getMaltLines());
            recipe.setHopLines(newRecipe.getHopLines());
            recipe.setYeastLines(newRecipe.getYeastLines());
            recipe.setWaterProfile(newRecipe.getWaterProfile());
            recipe.setStatus(newRecipe.getStatus());
            recipe.setMashSchedule(newRecipe.getMashSchedule());
            recipe.setStartDate(newRecipe.getStartDate());
            recipe.setEndDate(newRecipe.getEndDate());
            return recipeService.saveRecipe(recipe);
        }).orElseGet(() -> {
            newRecipe.setId(id);
            return recipeService.saveRecipe(newRecipe);
        });

        EntityModel<Recipe> entityModel = recipeModelAssembler.toModel(updatedRecipe);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/recipeId/{id}")
    ResponseEntity<?> deleteRecipe(@PathVariable String id) {
        recipeService.deleteByRecipeId(id);
        return ResponseEntity.noContent().build();
    }
}
