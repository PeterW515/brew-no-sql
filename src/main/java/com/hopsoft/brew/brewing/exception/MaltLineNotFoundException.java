package com.hopsoft.brew.brewing.exception;

public class MaltLineNotFoundException extends RuntimeException {
    public MaltLineNotFoundException(String id) {
        super("Could not find MaltLine " + id);
    }
}
