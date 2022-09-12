package com.hopsoft.brew.brewing.exception;

public class BrewingRunNotFoundException extends RuntimeException {
    public BrewingRunNotFoundException(String id) {
        super("Could not find BrewingRun " + id);
    }
}
