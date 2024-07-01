package com.bforbank.moneypot.application;

import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class AddAmountRequest {
    @Positive
    private double amount;
}