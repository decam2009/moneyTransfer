package com.example.moneytransfer.model;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@Getter
public class SuccessResponse {
    private UUID operationId;
    public SuccessResponse() {
        this.operationId = UUID.randomUUID();
    }
}
