package com.bforbank.moneypot.adapters.postgresql.dto;

import com.bforbank.moneypot.adapters.postgresql.model.PostgreSQLMoneyPot;
import com.bforbank.moneypot.domain.entity.MoneyPot;

public class MoneyPotDTO {
    public static MoneyPot toDomain(PostgreSQLMoneyPot postgreSQLMoneyPot) {
        return new MoneyPot(
                postgreSQLMoneyPot.getId(),
                postgreSQLMoneyPot.getClientId(),
                postgreSQLMoneyPot.getAmount(),
                postgreSQLMoneyPot.getNumberOfTransactions(),
                postgreSQLMoneyPot.getCreatedAt(),
                postgreSQLMoneyPot.getUpdatedAt()
        );
    }

    public static PostgreSQLMoneyPot toPersistent(MoneyPot moneyPot) {
        PostgreSQLMoneyPot postgreSQLMoneyPot = new PostgreSQLMoneyPot();
        postgreSQLMoneyPot.setId(moneyPot.getId());
        postgreSQLMoneyPot.setClientId(moneyPot.getClientId());
        postgreSQLMoneyPot.setAmount(moneyPot.getAmount());
        postgreSQLMoneyPot.setNumberOfTransactions(moneyPot.getNumberOfTransactions());
        postgreSQLMoneyPot.setCreatedAt(moneyPot.getCreatedAt());
        postgreSQLMoneyPot.setUpdatedAt(moneyPot.getUpdatedAt());
        return postgreSQLMoneyPot;
    }
}
