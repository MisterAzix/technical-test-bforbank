package com.bforbank.moneypot.domain.usecases;

public interface UseCase<UseCaseInput, UseCaseOutput> {
    abstract UseCaseOutput execute(UseCaseInput input);
}
