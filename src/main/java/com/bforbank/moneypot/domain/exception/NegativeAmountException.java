package com.bforbank.moneypot.domain.exception;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException() {
        super("Amount must be positive");
    }
}