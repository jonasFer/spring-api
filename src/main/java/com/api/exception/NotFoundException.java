package com.api.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class NotFoundException extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;

    public NotFoundException(String message) {
        super(message);
        this.message = message;
        this.httpStatus = HttpStatus.FOUND;
    }
}
