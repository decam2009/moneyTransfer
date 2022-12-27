package com.example.moneytransfer.exceptions;

import com.example.moneytransfer.model.responces.ErrorResponse;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.MissingFormatArgumentException;

@RestControllerAdvice
public class ResponseStatusAdvice {

    private final String MESSAGE400 = "Wrong request body parameters";
    private final String MESSAGE500 = "Server internal error. Check incoming data to server.";

    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handleBadRequestException() {
        ErrorResponse errorResponse = new ErrorResponse(MESSAGE400, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NullPointerException.class, UnexpectedTypeException.class, MissingFormatArgumentException.class})
    public ResponseEntity<ErrorResponse> handleNullPointerException() {
        ErrorResponse errorResponse = new ErrorResponse(MESSAGE500, HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
