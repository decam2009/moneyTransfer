package com.example.moneytransfer.repository;

import com.example.moneytransfer.model.Card;
import com.example.moneytransfer.model.Operation;
import org.springframework.stereotype.Repository;

public interface TransferRepository {
    void transfer (Card card);
    void confirmOperation (Operation operation);

}
