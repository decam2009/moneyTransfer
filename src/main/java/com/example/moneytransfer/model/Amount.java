package com.example.moneytransfer.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Amount {
    @NotBlank
    @Min(0)
    private Integer value;
    private String currency;
}
