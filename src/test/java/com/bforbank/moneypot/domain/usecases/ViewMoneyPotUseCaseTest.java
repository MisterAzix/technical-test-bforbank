package com.bforbank.moneypot.domain.usecases;

import com.bforbank.moneypot.adapters.local.repository.LocalMoneyPotRepository;
import com.bforbank.moneypot.domain.entity.MoneyPot;
import com.bforbank.moneypot.domain.exception.MoneyPotNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViewMoneyPotUseCaseTest {
    private final LocalMoneyPotRepository localMoneyPotRepository;

    ViewMoneyPotUseCaseTest() {
        this.localMoneyPotRepository = new LocalMoneyPotRepository();
    }

    @Test
    void should_return_money_pot_when_client_id_is_1() {
        // Given
        localMoneyPotRepository._populate(List.of(
                new MoneyPot(1L, 1L, 100L, 0, new Date(), new Date())
        ));
        ViewMoneyPotUseCase viewMoneyPotUseCase = new ViewMoneyPotUseCase(localMoneyPotRepository);
        ViewMoneyPotInput input = new ViewMoneyPotInput(1L);

        // When
        MoneyPot moneyPot = viewMoneyPotUseCase.execute(input);

        // Then
        assertNotNull(moneyPot);
        assertEquals(1L, moneyPot.getId());
        assertEquals(1L, moneyPot.getClientId());
        assertEquals(100L, moneyPot.getAmount());
        assertEquals(0, moneyPot.getNumberOfTransactions());
        assertFalse(moneyPot.isAvailable());
    }

    @Test
    void should_throw_exception_when_money_pot_not_found() {
        // Given
        Long clientId = 2L;
        localMoneyPotRepository._populate(List.of(
                new MoneyPot(1L, 1L, 100L, 0, new Date(), new Date())
        ));
        ViewMoneyPotUseCase viewMoneyPotUseCase = new ViewMoneyPotUseCase(localMoneyPotRepository);
        ViewMoneyPotInput input = new ViewMoneyPotInput(clientId);

        // When
        MoneyPotNotFoundException exception = assertThrows(MoneyPotNotFoundException.class, () -> viewMoneyPotUseCase.execute(input));

        // Then
        assertEquals("MoneyPot not found for clientId: " + clientId, exception.getMessage());
    }

    void should_return_isAvailable_when_number_of_transactions_is_3_and_amount_is_10() {
        // Given
        localMoneyPotRepository._populate(List.of(
                new MoneyPot(1L, 1L, 10L, 3, new Date(), new Date())
        ));
        ViewMoneyPotUseCase viewMoneyPotUseCase = new ViewMoneyPotUseCase(localMoneyPotRepository);
        ViewMoneyPotInput input = new ViewMoneyPotInput(1L);

        // When
        MoneyPot moneyPot = viewMoneyPotUseCase.execute(input);

        // Then
        assertNotNull(moneyPot);
        assertTrue(moneyPot.isAvailable());
    }
}