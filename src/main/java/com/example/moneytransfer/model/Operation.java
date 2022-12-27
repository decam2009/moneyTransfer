package com.example.moneytransfer.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Operation {
    @NotNull
    private static AtomicInteger operationId = new AtomicInteger();
    @NotBlank
    private String code;

    public static String generateId (){
        return String.valueOf(operationId.incrementAndGet());
    }
    public Operation() {
        generateId();
    }
}
