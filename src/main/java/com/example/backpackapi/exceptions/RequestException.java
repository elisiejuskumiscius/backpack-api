package com.example.backpackapi.exceptions;

public class RequestException extends RuntimeException {
    public RequestException(String errorMessage) {
        super(errorMessage);
    }
}
