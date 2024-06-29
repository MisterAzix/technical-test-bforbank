package com.bforbank.moneypot.domain.repository;

import com.bforbank.moneypot.domain.entity.MoneyPot;

import java.util.Optional;

public interface MoneyPotRepository {
    Optional<MoneyPot> findByClientId(Long clientId);
    void save(MoneyPot moneyPot);
}
