package com.capitole.tecnicaltest.price.infrastructure.web.controller;

import com.capitole.tecnicaltest.price.infrastructure.exception.Error;
import com.capitole.tecnicaltest.price.infrastructure.exception.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PriceHandler {

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Error> handle(PriceNotFoundException e) {
        Error error = new Error(e.getErrorCode(), e.getUserMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
