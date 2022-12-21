package com.example.moneytransfer.controller;

import com.example.moneytransfer.model.Card;
import com.example.moneytransfer.model.Operation;
import com.example.moneytransfer.service.TransferRepositoryImpl;
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

    @PostMapping(value = "/transfer")
    @CrossOrigin("http://localhost:3000")
    public void transfer(@RequestBody Card card) {
        repo.transfer(card);
    }

    @PostMapping(value = "/confirmOperation")
    @CrossOrigin("http://localhost:3000")
    public void confirm(@RequestBody Operation operation) {
        repo.confirmOperation(operation);
    }
}
