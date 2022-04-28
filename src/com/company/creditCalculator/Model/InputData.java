package com.company.creditCalculator.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class InputData {
    private static final BigDecimal PERCENT = BigDecimal.valueOf(100);
    private LocalDate repaymentStartDate = LocalDate.of(2022, 1,5);
    private BigDecimal wiborPercent = new BigDecimal("5.78");
    private BigDecimal amount = BigDecimal.valueOf(570000);
    private BigDecimal durationMonths = new BigDecimal("360");
    private RateType rateType = RateType.CONSTANT;
    private BigDecimal bankMargin = new BigDecimal("2.63");


    public InputData withRepaymentStartDate(LocalDate repaymentStartDate){
        this.repaymentStartDate=repaymentStartDate;
        return this;
    }
    public InputData withWiborPercent(BigDecimal wiborPercent){
        this.wiborPercent=wiborPercent;
        return this;
    }
    public InputData withAmount(BigDecimal amount){
        this.amount=amount;
        return this;
    }
    public InputData withDurationMonths(BigDecimal durationMonths){
        this.durationMonths=durationMonths;
        return this;
    }
    public InputData withRateType(RateType rateType){
        this.rateType=rateType;
        return this;
    }
    public InputData withBankMargin(BigDecimal bankMargin){
        this.bankMargin=bankMargin;
        return this;
    }

    public LocalDate getRepaymentStartDate() {
        return repaymentStartDate;
    }

    public BigDecimal getWiborPercent() {
        return wiborPercent;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getDurationMonths() {
        return durationMonths;
    }

    public RateType getRateType() {
        return rateType;
    }

    public BigDecimal getBankMargin() {
        return bankMargin;
    }

    public BigDecimal getInterestPercent(){
        return wiborPercent.add(bankMargin).divide(PERCENT, 4, RoundingMode.HALF_UP);
    }

    public BigDecimal getInterestDisplay(){
        return wiborPercent.add(bankMargin).setScale(2, RoundingMode.HALF_UP);
    }
}
