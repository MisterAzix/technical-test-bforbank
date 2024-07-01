package com.bforbank.moneypot.domain.entity;

import com.bforbank.moneypot.domain.exception.NegativeAmountException;
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
    boolean isAvailable;
    final Date createdAt;
    Date updatedAt;

    public MoneyPot(Long id, Long clientId, double amount, int numberOfTransactions, Date createdAt, Date updatedAt) {
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.numberOfTransactions = numberOfTransactions;
        this.isAvailable = this.checkAvailability();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void addAmount(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException();
        }
        this.amount += amount;
        this.updatedAt = new Date();
    }

    public void addNewTransaction() {
        this.numberOfTransactions++;
        this.updatedAt = new Date();
    }

    private boolean checkAvailability() {
        return this.numberOfTransactions >= 3 && this.amount >= 10;
    }
}
