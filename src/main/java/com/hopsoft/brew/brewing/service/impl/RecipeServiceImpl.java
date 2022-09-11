package com.hopsoft.brew.brewing.service.impl;

import com.hopsoft.brew.brewing.domain.Recipe;
import com.hopsoft.brew.brewing.repository.RecipeRepository;
import com.hopsoft.brew.brewing.service.api.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Optional<Recipe> findByRecipeId(String recipeId) {
        return recipeRepository.findById(recipeId);
    }

    @Override
    public void deleteByRecipeId(String recipeId) {
        recipeRepository.deleteById(recipeId);
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public boolean recipeExists(Recipe recipe) {
        return recipeRepository.exists(Example.of(recipe));
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public void deleteAll() {
        recipeRepository.deleteAll();
    }
}
