package com.capitole.tecnicaltest.price.infrastructure.web.controller;

import com.capitole.tecnicaltest.price.infrastructure.exception.Error;
import com.capitole.tecnicaltest.price.infrastructure.exception.PriceNotFoundException;
import com.capitole.tecnicaltest.price.infrastructure.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class PriceHandler {

    @ExceptionHandler({PriceNotFoundException.class})
    public ResponseEntity<Error> handle(PriceNotFoundException e) {
        Error error = new Error(e.getErrorCode(), e.getUserMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ValidationException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Error> handleException(Exception e) {
        String errorCode;
        String userMessage;

        if (e instanceof ValidationException) {
            ValidationException validationException = (ValidationException) e;
            errorCode = validationException.getErrorCode();
            userMessage = validationException.getUserMessage();
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException typeMismatchException = (MethodArgumentTypeMismatchException) e;
            errorCode = typeMismatchException.getErrorCode();
            userMessage = typeMismatchException.getMessage();
        } else {
            errorCode = "UnknownError";
            userMessage = "An unexpected error occurred.";
        }

        Error error = new Error(errorCode, userMessage);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
