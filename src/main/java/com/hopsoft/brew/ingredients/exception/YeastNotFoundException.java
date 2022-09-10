package com.hopsoft.brew.ingredients.exception;

public class YeastNotFoundException extends RuntimeException {
    public YeastNotFoundException(String id) {
        super("Could not find yeast " + id);
    }
}
