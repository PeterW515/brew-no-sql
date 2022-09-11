package com.hopsoft.brew.brewing.service.api;

import com.hopsoft.brew.brewing.domain.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    Recipe saveRecipe(Recipe recipe);

    Optional<Recipe> findByRecipeId(String recipeId);

    void deleteByRecipeId(String recipeId);

    void updateRecipe(Recipe recipe);

    boolean recipeExists(Recipe recipe);

    List<Recipe> findAll();

    void deleteAll();
}
