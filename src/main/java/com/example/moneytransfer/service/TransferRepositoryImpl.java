package com.example.moneytransfer.service;

import com.example.moneytransfer.exception.SuccessException;
import com.example.moneytransfer.model.Card;
import com.example.moneytransfer.model.Operation;
import com.example.moneytransfer.repository.TransferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransferRepositoryImpl implements TransferRepository {

    private void throwCustomSuccessException() {
        throw new SuccessException();
    }

    @Override
    public void transfer(Card card) {
        log.info("Operation:" +  card.getCardFromNumber() + " " + card.getCardFromValidTill() + " " + card.getCardToNumber() + " " +
                card.getAmount().getCurrency() + " " + card.getAmount().getValue());
        throwCustomSuccessException();
    }

    @Override
    public void confirmOperation(Operation operation) {
        log.info("Confirm operation id: " + operation.getOperationId());
        throwCustomSuccessException();
    }
}
