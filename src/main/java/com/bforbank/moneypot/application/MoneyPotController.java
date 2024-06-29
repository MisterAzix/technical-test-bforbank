package com.bforbank.moneypot.application;

import com.bforbank.moneypot.domain.entity.MoneyPot;
import com.bforbank.moneypot.domain.usecases.AddAmountToMoneyPotInput;
import com.bforbank.moneypot.domain.usecases.AddAmountToMoneyPotUseCase;
import com.bforbank.moneypot.domain.usecases.ViewMoneyPotInput;
import com.bforbank.moneypot.domain.usecases.ViewMoneyPotUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moneypots")
public class MoneyPotController {
    private final AddAmountToMoneyPotUseCase addAmountToMoneyPotUseCase;
    private final ViewMoneyPotUseCase viewMoneyPotUseCase;

    @Autowired
    public MoneyPotController(AddAmountToMoneyPotUseCase addAmountToMoneyPotUseCase, ViewMoneyPotUseCase viewMoneyPotUseCase) {
        this.addAmountToMoneyPotUseCase = addAmountToMoneyPotUseCase;
        this.viewMoneyPotUseCase = viewMoneyPotUseCase;
    }

    @PostMapping("/{clientId}")
    public ResponseEntity<Void> addAmount(@PathVariable Long clientId, @RequestBody double amount) {
        try {
            AddAmountToMoneyPotInput input = new AddAmountToMoneyPotInput(
                    clientId,
                    amount
            );
            addAmountToMoneyPotUseCase.execute(input);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<MoneyPot> viewMoneyPot(@PathVariable Long clientId) {
        try {
            ViewMoneyPotInput input = new ViewMoneyPotInput(clientId);
            MoneyPot moneyPot = viewMoneyPotUseCase.execute(input);
            return ResponseEntity.ok(moneyPot);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}