package com.example.moneytransfer.controller;

import com.example.moneytransfer.model.Card;
import com.example.moneytransfer.model.Operation;
import com.example.moneytransfer.model.responces.SuccessResponce;
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
    private static SuccessResponce successResponce = new SuccessResponce();

    public TransferController(TransferRepositoryImpl repo) {
        this.repo = repo;
    }

    @PostMapping(value = "/transfer", produces = "application/json")
    @CrossOrigin("http://localhost:3000")
    public SuccessResponce transfer(@Valid @RequestBody Card card) {
        repo.transfer(card);
        return successResponce;
    }

    @PostMapping(value = "/confirmOperation")
    @CrossOrigin("http://localhost:3000")
    public SuccessResponce confirm(@Valid @RequestBody Operation operation) {
        repo.confirmOperation(operation);
        return successResponce;
    }
}
