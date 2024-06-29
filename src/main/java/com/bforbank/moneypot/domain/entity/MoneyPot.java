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
}
