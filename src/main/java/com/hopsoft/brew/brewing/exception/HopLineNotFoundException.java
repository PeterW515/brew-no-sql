package com.hopsoft.brew.brewing.exception;

public class HopLineNotFoundException extends RuntimeException {
    public HopLineNotFoundException(String id) {
        super("Could not find HopLine " + id);
    }
}
