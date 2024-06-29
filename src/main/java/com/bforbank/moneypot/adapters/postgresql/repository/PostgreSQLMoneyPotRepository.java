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
    private final PostgreSQLJpaRepository postgresSQLJpaRepository;

    @Autowired
    public PostgreSQLMoneyPotRepository(PostgreSQLJpaRepository postgresSQLJpaRepository) {
        this.postgresSQLJpaRepository = postgresSQLJpaRepository;
    }

    @Override
    public Optional<MoneyPot> findByClientId(Long clientId) {
        PostgreSQLMoneyPot postgreSQLMoneyPot = this.postgresSQLJpaRepository.findByClientId(clientId).orElse(null);
        assert postgreSQLMoneyPot != null;
        return Optional.of(MoneyPotDTO.toDomain(postgreSQLMoneyPot));
    }

    @Override
    public void save(MoneyPot moneyPot) {
        PostgreSQLMoneyPot persistentMoneyPot = MoneyPotDTO.toPersistent(moneyPot);
        this.postgresSQLJpaRepository.save(persistentMoneyPot);
    }
}
