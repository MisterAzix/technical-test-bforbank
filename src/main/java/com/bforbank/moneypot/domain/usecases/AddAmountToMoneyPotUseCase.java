package com.bforbank.moneypot.domain.usecases;

import com.bforbank.moneypot.domain.exception.MoneyPotNotFoundException;
import com.bforbank.moneypot.domain.exception.NegativeAmountException;
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
    public MoneyPot execute(AddAmountToMoneyPotInput input) throws NegativeAmountException, MoneyPotNotFoundException {
        MoneyPot moneyPot = moneyPotRepository.findByClient_id(input.clientId())
                .orElseThrow(() -> new MoneyPotNotFoundException(input.clientId()));
        moneyPot.addAmount(input.amount());
        moneyPot.addNewTransaction();
        moneyPotRepository.save(moneyPot);
        return moneyPot;
    }
}