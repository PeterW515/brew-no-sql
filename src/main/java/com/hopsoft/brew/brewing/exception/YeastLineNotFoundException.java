package com.hopsoft.brew.brewing.exception;

public class YeastLineNotFoundException extends RuntimeException {
    public YeastLineNotFoundException(String id) {
        super("Could not find YeastLine " + id);
    }
}
