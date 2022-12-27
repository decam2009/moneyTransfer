package com.example.moneytransfer.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.beans.Transient;
import java.time.Year;

@Data
public class Card {

    @CreditCardNumber
    private String cardFromNumber;

    @NotBlank
    @Min(1)
    @Max(12)
    private transient Integer month;
    @NotBlank
    private transient Integer year;
    @NotBlank
    private String cardFromValidTill;
    @NotBlank
    @Size(min = 3, max = 3)
    private String cardFromCVV;
    @CreditCardNumber
    private String cardToNumber;
    private Amount amount;
}
