package com.capitole.tecnicaltest.price.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class PriceNotFoundException extends RuntimeException {

    private final String errorCode = "PRICE-01";
    private final String userMessage = "Price Not found";
    private final Integer httpStatus = HttpStatus.NOT_FOUND.value();

}
