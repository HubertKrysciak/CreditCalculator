package com.company.creditCalculator.Model;

import java.math.BigDecimal;

public class Rate {
    private TimePoint timePoint;
    private final BigDecimal rateNumber;
    private final RateAmounts rateAmounts;
    private final MortgageResidual mortgageResidual;
    private final MorgageReference morgageReference;

    public Rate(TimePoint timePoint,
                BigDecimal rateNumber,
                RateAmounts rateAmounts,
                MortgageResidual mortgageResidual,
                MorgageReference morgageReference) {
        this.timePoint = timePoint;
        this.rateNumber = rateNumber;
        this.rateAmounts = rateAmounts;
        this.mortgageResidual = mortgageResidual;
        this.morgageReference = morgageReference;
    }

    public TimePoint getTimePoint() {
        return timePoint;
    }

    public BigDecimal getRateNumber() {
        return rateNumber;
    }

    public RateAmounts getRateAmounts() {
        return rateAmounts;
    }

    public MortgageResidual getMortgageResidual() {
        return mortgageResidual;
    }

    public MorgageReference getMorgageReference() {
        return morgageReference;
    }
}
