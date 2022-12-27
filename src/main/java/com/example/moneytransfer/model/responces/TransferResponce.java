package com.example.moneytransfer.model.responces;

import com.example.moneytransfer.model.Operation;
import lombok.Data;

@Data
public class TransferResponce {
    String operationId;

    public TransferResponce() {
        this.operationId = Operation.generateId();
    }
}
