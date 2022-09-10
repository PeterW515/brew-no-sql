package com.hopsoft.brew.ingredients.controller.advice;

import com.hopsoft.brew.ingredients.exception.MaltNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MaltNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MaltNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String maltNotFoundHandler(MaltNotFoundException ex){
        return ex.getMessage();
    }
}
