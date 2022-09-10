package com.hopsoft.brew.ingredients.exception;

public class MaltNotFoundException extends RuntimeException {
    public MaltNotFoundException(String id) {
        super("Could not find malt " + id);
    }
}
