package com.hopsoft.brew.brewing.exception;

public class UnitOfMeasureNotFoundException extends RuntimeException {
    public UnitOfMeasureNotFoundException(String id) {
        super("Could not find UnitOfMeasure " + id);
    }
}
