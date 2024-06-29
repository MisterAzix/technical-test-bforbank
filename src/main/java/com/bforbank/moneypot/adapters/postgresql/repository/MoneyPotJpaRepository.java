package com.bforbank.moneypot.adapters.postgresql.repository;

import com.bforbank.moneypot.adapters.postgresql.model.PostgreSQLMoneyPot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoneyPotJpaRepository extends JpaRepository<PostgreSQLMoneyPot, Long> {
    Optional<PostgreSQLMoneyPot> findByClientId(Long clientId);
}

