package com.hopsoft.brew.ingredients.exception;

public class HopNotFoundException extends RuntimeException {
    public HopNotFoundException(String id) {
        super("Could not find hop " + id);
    }
}
