package com.bforbank.moneypot.adapters.local.repository;

import com.bforbank.moneypot.domain.entity.MoneyPot;
import com.bforbank.moneypot.domain.repository.MoneyPotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LocalMoneyPotRepository implements MoneyPotRepository {
    private List<MoneyPot> moneyPots;

    public void _populate(List<MoneyPot> moneyPots) {
        this.moneyPots = new ArrayList<>(moneyPots);
    }

    @Override
    public Optional<MoneyPot> findByClientId(Long clientId) {
        return moneyPots.stream()
                .filter(moneyPot -> Objects.equals(moneyPot.getClientId(), clientId))
                .findFirst();
    }

    @Override
    public void save(MoneyPot moneyPot) {
        moneyPots.removeIf(pot -> Objects.equals(pot.getId(), moneyPot.getId()));
        moneyPots.add(moneyPot);
    }
}
