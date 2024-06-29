package com.bforbank.moneypot.domain.repository;

import com.bforbank.moneypot.domain.entity.MoneyPot;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoneyPotRepository {
    Optional<MoneyPot> findByClientId(Long clientId);
    void save(MoneyPot moneyPot);
}
