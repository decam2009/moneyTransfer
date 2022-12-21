package com.example.moneytransfer.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Operation {
    private UUID operationId;
    private String code;

}
