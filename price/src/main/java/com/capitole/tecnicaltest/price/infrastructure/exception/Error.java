package com.capitole.tecnicaltest.price.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {

    private final String errorCode;

    private final String userMessage;
}
