package com.example.moneytransfer.repository;

import com.example.moneytransfer.model.Card;
import com.example.moneytransfer.model.Operation;

public interface TransferRepository {
    void transfer (Card card);
    void confirmOperation (Operation operation);

    void save (String operationId,  Card card);

    Boolean findOperationById (String operationId);

}
