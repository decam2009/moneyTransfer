package com.example.moneytransfer.model.responces;

import com.example.moneytransfer.model.Operation;
import lombok.Data;

@Data
public class SuccessResponce {
    String operationId;

    public SuccessResponce() {
        this.operationId = Operation.generateId();
    }
}
