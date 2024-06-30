package com.bforbank.moneypot.domain.usecases;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bforbank.moneypot.domain.entity.MoneyPot;
import com.bforbank.moneypot.domain.repository.MoneyPotRepository;

@Service
public class AddAmountToMoneyPotUseCase implements UseCase<AddAmountToMoneyPotInput, MoneyPot> {
    private final MoneyPotRepository moneyPotRepository;

    @Autowired
    AddAmountToMoneyPotUseCase(MoneyPotRepository moneyPotRepository) {
        this.moneyPotRepository = moneyPotRepository;
    }

    @Override
    public MoneyPot execute(AddAmountToMoneyPotInput input) {
        MoneyPot moneyPot = moneyPotRepository.findByClientId(input.clientId())
                .orElseThrow(() -> new IllegalArgumentException("MoneyPot not found"));
        moneyPot.addAmount(input.amount());
        moneyPot.addNewTransaction();
        moneyPotRepository.save(moneyPot);
        return moneyPot;
    }
}