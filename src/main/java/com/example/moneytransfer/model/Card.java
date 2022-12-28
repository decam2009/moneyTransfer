package com.example.moneytransfer.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.beans.Transient;

@Data
public class Card {
    @NotBlank
    @CreditCardNumber
    private String cardFromNumber;
    @NotBlank
    private String cardFromValidTill;
    @NotBlank
    @Size(min = 3, max = 3)
    private String cardFromCVV;
    @NotBlank
    @CreditCardNumber
    private String cardToNumber;
    @Valid
    private Amount amount;
}
