package com.bforbank.moneypot.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MoneyPot {
    final Long id;
    Long clientId;
    double amount;
    int numberOfTransactions;
    final Date createdAt;
    Date updatedAt;

    public MoneyPot(Long id, Long clientId, double amount, int numberOfTransactions, Date createdAt, Date updatedAt) {
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.numberOfTransactions = numberOfTransactions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void addAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.amount += amount;
        this.updatedAt = new Date();
    }

    public void addNewTransaction() {
        this.numberOfTransactions++;
        this.updatedAt = new Date();
    }
}
