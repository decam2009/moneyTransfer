package com.example.moneytransfer.model;

import lombok.Data;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Operation {
    private AtomicInteger operationId;
    private String code;

}
