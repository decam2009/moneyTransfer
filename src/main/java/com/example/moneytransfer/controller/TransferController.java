package com.example.moneytransfer.controller;

import com.example.moneytransfer.model.Card;
import com.example.moneytransfer.model.Operation;
import com.example.moneytransfer.model.responces.ErrorResponse;
import com.example.moneytransfer.model.responces.SuccessResponse;
import com.example.moneytransfer.repository.TransferRepositoryImpl;
import com.example.moneytransfer.utils.FileStorage;
import com.example.moneytransfer.utils.OperationIDGenerator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class TransferController {

    @Value("${file.path:''}")
    private String filePath;

    private final TransferRepositoryImpl repo;
    private static final SuccessResponse successResponce = new SuccessResponse();
    private String operationId;

    public TransferController(TransferRepositoryImpl repo) {
        this.repo = repo;
    }

    @PostMapping(value = "/transfer", produces = "application/json")
    @CrossOrigin("http://localhost:3000")
    public SuccessResponse transfer(@Valid @RequestBody Card card) throws IOException {
        operationId = OperationIDGenerator.generateId();
        successResponce.setOperationId(operationId);
        FileStorage.createStorageFileIfNotExists(filePath);
        repo.transfer(card);
        if (HttpStatus.OK.is2xxSuccessful()) {
            repo.save(operationId, card);
            FileStorage.saveToFileStorage(operationId, card);
        }
        return successResponce;
    }

    @PostMapping(value = "/confirmOperation")
    @CrossOrigin("http://localhost:3000")
    public SuccessResponse confirm(@Valid @RequestBody Operation operation) throws IOException {
        if (repo.findOperationById(operation.getOperationId())) {
            repo.confirmOperation(operation);
            successResponce.setOperationId(operation.getOperationId());
            FileStorage.saveToFileStorage(operation.getOperationId(), null);
        }
        return successResponce;
    }
}
