package com.hopsoft.brew.brewing.exception;

public class MashRestNotFoundException extends RuntimeException {
    public MashRestNotFoundException(String id) {
        super("Could not find MashRest " + id);
    }
}
