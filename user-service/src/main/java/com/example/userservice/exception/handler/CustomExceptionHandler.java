package com.example.userservice.exception.handler;


import com.example.userservice.dto.ErrorResponse;
import com.example.userservice.exception.RecordNotFoundException;
import com.example.userservice.exception.UserNotAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private String USER_NOT_ALLOWED_TO_VOTE = "User doesn't have voting rights.\\n Hence Couldn't be registered";
    private String NO_RECORDS_FOUND = "User is not registered";

    /**
     * This handler handles the User age and throws if  not valid Exception
     */
    @ExceptionHandler(UserNotAllowedException.class)
    public  final ResponseEntity<ErrorResponse> handleUserNotAllowed(UserNotAllowedException e, WebRequest w){
        List<String> errorDetails = new ArrayList<>();
        errorDetails.add(e.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, USER_NOT_ALLOWED_TO_VOTE);
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * This handler handles the Record Not Found Exception
     */
    @ExceptionHandler(RecordNotFoundException.class)
    public  final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException e, WebRequest w){
        List<String> errorDetails = new ArrayList<>();
        errorDetails.add(e.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,NO_RECORDS_FOUND);
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
