package com.example.moneytransfer.controller;

import com.example.moneytransfer.model.Card;
import com.example.moneytransfer.model.Operation;
import com.example.moneytransfer.model.responces.TransferResponce;
import com.example.moneytransfer.repository.TransferRepositoryImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private final TransferRepositoryImpl repo;

    public TransferController(TransferRepositoryImpl repo) {
        this.repo = repo;
    }

    @PostMapping(value = "/transfer", produces = "application/json")
    @CrossOrigin("http://localhost:3000")
    public TransferResponce transfer(@Valid @RequestBody Card card) {
        TransferResponce success = null;
        repo.transfer(card);
        if (HttpStatus.ACCEPTED.is2xxSuccessful()) {
            success = new TransferResponce();
        }
        return success;
    }

    @PostMapping(value = "/confirmOperation")
    @CrossOrigin("http://localhost:3000")
    public void confirm(@Valid @RequestBody Operation operation) {
        repo.confirmOperation(operation);
    }
}
