package com.bforbank.moneypot.domain.usecases;

import com.bforbank.moneypot.adapters.local.repository.LocalMoneyPotRepository;
import com.bforbank.moneypot.domain.entity.MoneyPot;
import com.bforbank.moneypot.domain.exception.MoneyPotNotFoundException;
import com.bforbank.moneypot.domain.exception.NegativeAmountException;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddAmountToMoneyPotUseCaseTest {
    private final LocalMoneyPotRepository localMoneyPotRepository;

    AddAmountToMoneyPotUseCaseTest() {
        this.localMoneyPotRepository = new LocalMoneyPotRepository();
    }


    @Test
    void should_return_200_when_current_amount_is_100_and_adding_100() {
        // Given
        localMoneyPotRepository._populate(List.of(
                new MoneyPot(1L, 1L, 100L, 0, new Date(), new Date())
        ));
        AddAmountToMoneyPotUseCase addAmountToMoneyPotUseCase = new AddAmountToMoneyPotUseCase(localMoneyPotRepository);
        AddAmountToMoneyPotInput input = new AddAmountToMoneyPotInput(1L, 100L);

        // When
        MoneyPot moneyPot = addAmountToMoneyPotUseCase.execute(input);

        // Then
        assertNotNull(moneyPot);
        assertEquals(1L, moneyPot.getId());
        assertEquals(200L, moneyPot.getAmount());
    }

    @Test
    void should_increase_number_of_transactions_when_adding_amount_to_money_pot() {
        // Given
        localMoneyPotRepository._populate(List.of(
                new MoneyPot(1L, 1L, 100L, 0, new Date(), new Date())
        ));
        AddAmountToMoneyPotUseCase addAmountToMoneyPotUseCase = new AddAmountToMoneyPotUseCase(localMoneyPotRepository);
        AddAmountToMoneyPotInput input = new AddAmountToMoneyPotInput(1L, 100L);

        // When
        MoneyPot moneyPot = addAmountToMoneyPotUseCase.execute(input);

        // Then
        assertNotNull(moneyPot);
        assertEquals(1L, moneyPot.getId());
        assertEquals(200L, moneyPot.getAmount());
        assertEquals(1, moneyPot.getNumberOfTransactions());
    }

    @Test
    void should_throw_exception_when_money_pot_not_found() {
        // Given
        Long clientId = 4L;
        localMoneyPotRepository._populate(List.of(
                new MoneyPot(1L, 1L, 100L, 0, new Date(), new Date())
        ));
        AddAmountToMoneyPotUseCase addAmountToMoneyPotUseCase = new AddAmountToMoneyPotUseCase(localMoneyPotRepository);
        AddAmountToMoneyPotInput input = new AddAmountToMoneyPotInput(clientId, 100L);

        // When
        MoneyPotNotFoundException exception = assertThrows(MoneyPotNotFoundException.class, () -> addAmountToMoneyPotUseCase.execute(input));

        // Then
        assertEquals("MoneyPot not found for clientId: " + clientId, exception.getMessage());
    }

    @Test
    void should_throw_exception_when_amount_is_negative() {
        // Given
        localMoneyPotRepository._populate(List.of(
                new MoneyPot(1L, 1L, 100L, 0, new Date(), new Date())
        ));
        AddAmountToMoneyPotUseCase addAmountToMoneyPotUseCase = new AddAmountToMoneyPotUseCase(localMoneyPotRepository);
        AddAmountToMoneyPotInput input = new AddAmountToMoneyPotInput(1L, -100L);

        // When
        NegativeAmountException exception = assertThrows(NegativeAmountException.class, () -> addAmountToMoneyPotUseCase.execute(input));

        // Then
        assertEquals("Amount must be positive", exception.getMessage());
    }
}