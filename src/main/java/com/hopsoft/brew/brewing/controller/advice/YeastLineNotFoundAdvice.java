package com.hopsoft.brew.brewing.controller.advice;

import com.hopsoft.brew.brewing.exception.YeastLineNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class YeastLineNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(YeastLineNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String yeastLineNotFoundHandler(YeastLineNotFoundException ex) {
        return ex.getMessage();
    }
}
