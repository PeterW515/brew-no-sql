package com.hopsoft.brew.ingredients.controller.advice;

import com.hopsoft.brew.ingredients.exception.HopNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HopNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(HopNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String hopNotFoundHandler(HopNotFoundException ex){
        return ex.getMessage();
    }
}
