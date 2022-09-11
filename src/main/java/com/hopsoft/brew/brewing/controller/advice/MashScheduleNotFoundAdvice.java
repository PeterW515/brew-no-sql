package com.hopsoft.brew.brewing.controller.advice;

import com.hopsoft.brew.brewing.exception.MashScheduleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MashScheduleNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MashScheduleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String mashScheduleNotFoundHandler(MashScheduleNotFoundException ex) {
        return ex.getMessage();
    }
}
