package com.example.userservice.exception;

public class UserNotAllowedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserNotAllowedException(String message) {
        super(message);
    }
}
