package com.example.moneytransfer.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Amount {
    @NotNull
    @Positive
    private Integer value;
    private String currency;
}
