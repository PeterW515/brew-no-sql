package com.hopsoft.brew.brewing.controller.advice;

import com.hopsoft.brew.brewing.exception.MaltLineNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MaltLineNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MaltLineNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String maltLineNotFoundHandler(MaltLineNotFoundException ex) {
        return ex.getMessage();
    }
}
