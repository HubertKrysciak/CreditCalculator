package com.company.creditCalculator.Service;

public class MortgageException extends RuntimeException{

    public MortgageException() {
        super("Case not handled");
    }
}
