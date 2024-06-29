package com.bforbank.moneypot.adapters.postgresql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class PostgreSQLMoneyPot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clientId;
    private double amount;
    private int numberOfTransactions;
    private Date createdAt;
    private Date updatedAt;
}
