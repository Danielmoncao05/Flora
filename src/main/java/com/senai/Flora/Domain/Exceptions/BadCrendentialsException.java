package com.senai.Flora.Domain.Exceptions;

public class BadCrendentialsException extends RuntimeException {
    public BadCrendentialsException(String message) {
        super(message);
    }
}
