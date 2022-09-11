package com.hopsoft.brew.brewing.exception;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(String id) {
        super("Could not find Recipe " + id);
    }
}
