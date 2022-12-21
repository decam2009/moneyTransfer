package com.example.moneytransfer.exception;

import com.example.moneytransfer.model.ErrorResponse;
import com.example.moneytransfer.model.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseStatusAdvice {

    private final String MESSAGE = "Wrong request body parameters";

    @ExceptionHandler(SuccessException.class)
    public SuccessResponse handleSuccessException() {
        return new SuccessResponse();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException() {
        ErrorResponse errorResponse = new ErrorResponse(MESSAGE, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException() {
        ErrorResponse errorResponse = new ErrorResponse(MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
