package com.hopsoft.brew.brewing.exception;

public class MashScheduleNotFoundException extends RuntimeException {
    public MashScheduleNotFoundException(String id) {
        super("Could not find MashSchedule " + id);
    }
}
