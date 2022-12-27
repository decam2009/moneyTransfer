package com.example.moneytransfer.repository;

import com.example.moneytransfer.model.Card;
import com.example.moneytransfer.model.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class TransferRepositoryImpl implements TransferRepository {

    @Override
    public void transfer(Card card) {
        log.info("Operation:%s %s/%s %s %d".formatted(card.getCardFromNumber(),
                card.getCardFromCVV(),
                card.getCardToNumber(),
                card.getAmount().getCurrency(),
                card.getAmount().getValue()));
    }

    @Override
    public void confirmOperation(Operation operation) {
        log.info("Confirm operation id: ");

    }
}
