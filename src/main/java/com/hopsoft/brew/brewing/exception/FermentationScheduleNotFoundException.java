package com.hopsoft.brew.brewing.exception;

public class FermentationScheduleNotFoundException extends RuntimeException {
    public FermentationScheduleNotFoundException(String id) {
        super("Could not find FermentationSchedule " + id);
    }
}
