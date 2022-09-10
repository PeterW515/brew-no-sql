package com.hopsoft.brew.ingredients.controller.advice;

import com.hopsoft.brew.ingredients.exception.WaterProfileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WaterProfileNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(WaterProfileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String waterProfileNotFoundHandler(WaterProfileNotFoundException ex){
        return ex.getMessage();
    }
}
