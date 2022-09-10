package com.hopsoft.brew.ingredients.exception;

public class WaterProfileNotFoundException extends RuntimeException {
    public WaterProfileNotFoundException(String id) {
        super("Could not find waterProfile " + id);
    }
}
