package com.capitole.tecnicaltest.price.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ValidationException extends RuntimeException {

    private final String errorCode = "PRICE-02";
    private final String userMessage = "Validation Exception, please check the param values";
    private final Integer httpStatus = HttpStatus.BAD_REQUEST.value();

}
