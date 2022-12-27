package com.example.moneytransfer.repository;

import com.example.moneytransfer.model.Card;
import com.example.moneytransfer.model.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
@Slf4j
public class TransferRepositoryImpl implements TransferRepository {

    private static final ConcurrentHashMap<String, Card> transferStorage = new ConcurrentHashMap<>();


    @Override
    public void transfer(Card card) {
        log.info("Operation:%s %s %s %d %s".formatted(card.getCardFromNumber(),
                card.getCardFromValidTill(),
                card.getCardToNumber(),
                card.getAmount().getValue(),
                card.getAmount().getCurrency()));
    }

    @Override
    public void confirmOperation(Operation operation) {
        log.info("Confirm operation id: " + operation.getOperationId());
    }

    @Override
    public void save(Card card) {
        transferStorage.put(Operation.generateId(), card);
    }

    @Override
    public Card findOperationById(String operationId) {
        return transferStorage.get(operationId);
    }
}
