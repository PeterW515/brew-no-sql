package com.hopsoft.brew.brewing.controller.advice;

import com.hopsoft.brew.brewing.exception.FermentationScheduleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FermentationScheduleNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(FermentationScheduleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String fermentationScheduleNotFoundHandler(FermentationScheduleNotFoundException ex) {
        return ex.getMessage();
    }
}
