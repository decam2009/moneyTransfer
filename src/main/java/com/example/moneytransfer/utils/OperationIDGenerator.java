package com.example.moneytransfer.utils;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class OperationIDGenerator {
    private static AtomicInteger operationId = new AtomicInteger();

    public static String generateId (){
        return (String.valueOf(operationId.incrementAndGet()));
    }
}
