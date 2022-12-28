package com.example.moneytransfer.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Operation {
    @NotNull
    private String operationId;
    @NotBlank
    @Size(max = 4)
    private String code;

    public String getOperationId() {
        return operationId;
    }
}
