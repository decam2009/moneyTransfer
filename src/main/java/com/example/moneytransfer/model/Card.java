package com.example.moneytransfer.model;

import lombok.Data;

@Data
public class Card {
    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private String cardToNumber;
    private Amount amount;
}
