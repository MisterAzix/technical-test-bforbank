package com.bforbank.moneypot.domain.exception;

public class MoneyPotNotFoundException extends RuntimeException {
    public MoneyPotNotFoundException(Long clientId) {
        super("MoneyPot not found for clientId: " + clientId);
    }
}