package com.example.userservice.dto;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    private int statusCode;



    public ErrorResponse(HttpStatus status, String message) {
        this.message = message;
        this.statusCode = status.value();
    }
}
