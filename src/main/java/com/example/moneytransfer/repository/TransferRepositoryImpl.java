package com.example.moneytransfer.repository;

import com.example.moneytransfer.exception.SuccessException;
import com.example.moneytransfer.model.Card;
import com.example.moneytransfer.model.Operation;
import com.example.moneytransfer.repository.TransferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Slf4j
public class TransferRepositoryImpl implements TransferRepository {

    private void throwCustomSuccessException() {
        throw new SuccessException();
    }

    @Override
    public void transfer(Card card) {
        log.info("Operation:%s %d/%s %s %s %d".formatted(card.getCardFromNumber(),
                card.getMonth(),
                card.getYear(),
                card.getCardToNumber(),
                card.getAmount().getCurrency(),
                card.getAmount().getValue()));
        throwCustomSuccessException();
    }

    @Override
    public void confirmOperation(Operation operation) {
        log.info("Confirm operation id: " + operation.getOperationId());
        throwCustomSuccessException();
    }
}
