package com.example.moneytransfer.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private Integer id;

    public ErrorResponse(String message, Integer id) {
        this.message = message;
        this.id = id;
    }
}
