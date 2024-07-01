package com.bforbank.moneypot.adapters.postgresql.repository;

import com.bforbank.moneypot.adapters.postgresql.dto.MoneyPotDTO;
import com.bforbank.moneypot.adapters.postgresql.model.PostgreSQLMoneyPot;
import com.bforbank.moneypot.domain.entity.MoneyPot;
import com.bforbank.moneypot.domain.repository.MoneyPotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PostgreSQLMoneyPotRepository implements MoneyPotRepository {
    private final MoneyPotJpaRepository moneyPotJpaRepository;

    @Autowired
    public PostgreSQLMoneyPotRepository(MoneyPotJpaRepository moneyPotJpaRepository) {
        this.moneyPotJpaRepository = moneyPotJpaRepository;
    }

    @Override
    public Optional<MoneyPot> findByClientId(Long clientId) {
        PostgreSQLMoneyPot postgreSQLMoneyPot = this.moneyPotJpaRepository.findByClientId(clientId).orElse(null);
        if (postgreSQLMoneyPot == null) {
            return Optional.empty();
        }
        return Optional.of(MoneyPotDTO.toDomain(postgreSQLMoneyPot));
    }

    @Override
    public void save(MoneyPot moneyPot) {
        PostgreSQLMoneyPot persistentMoneyPot = MoneyPotDTO.toPersistent(moneyPot);
        this.moneyPotJpaRepository.save(persistentMoneyPot);
    }
}
