package com.bforbank.moneypot.domain.usecases;

import com.bforbank.moneypot.domain.entity.MoneyPot;
import com.bforbank.moneypot.domain.repository.MoneyPotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewMoneyPotUseCase implements UseCase<ViewMoneyPotInput, MoneyPot> {
    private final MoneyPotRepository moneyPotRepository;

    @Autowired
    public ViewMoneyPotUseCase(MoneyPotRepository moneyPotRepository) {
        this.moneyPotRepository = moneyPotRepository;
    }

    @Override
    public MoneyPot execute(ViewMoneyPotInput input) {
        return moneyPotRepository.findByClientId(input.clientId())
                .orElseThrow(() -> new IllegalArgumentException("Money pot not found"));
    }
}
