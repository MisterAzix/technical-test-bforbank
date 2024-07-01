package com.bforbank.moneypot.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.bforbank.moneypot.domain.exception.MoneyPotNotFoundException;
import com.bforbank.moneypot.domain.exception.NegativeAmountException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MoneyPotNotFoundException.class)
    public ResponseEntity<String> handleMoneyPotNotFoundException(MoneyPotNotFoundException ex) {
        logger.error("Handling MoneyPotNotFoundException", ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NegativeAmountException.class)
    public ResponseEntity<String> handleNegativeAmountException(NegativeAmountException ex) {
        logger.error("Handling NegativeAmountException", ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}