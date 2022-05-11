package com.company.creditCalculator.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Map;

public class InputData {
    private static final BigDecimal PERCENT = BigDecimal.valueOf(100);
    private LocalDate repaymentStartDate = LocalDate.of(2022, 1,5);
    private BigDecimal wiborPercent = new BigDecimal("1.73");
    private BigDecimal amount = BigDecimal.valueOf(298000);
    private BigDecimal durationMonths = new BigDecimal("360");
    private RateType rateType = RateType.CONSTANT;
    private BigDecimal bankMargin = new BigDecimal("1.90");

    private Map<Integer, BigDecimal> overpaymentSchema = Map.of(
            5, BigDecimal.valueOf(10000),
            6, BigDecimal.valueOf(10000),
            7, BigDecimal.valueOf(10000),
            8, BigDecimal.valueOf(10000)
    );

    private String overpaymentReduceWay = Overpayment.REDUCE_PERIOD;

    private BigDecimal overpaymentProvisionPercent = BigDecimal.valueOf(3);
    private BigDecimal overpaymentProvisionMonths = BigDecimal.valueOf(36);

    public InputData withOverpaymentReduceWay(String overpaymentReduceWay){
        this.overpaymentReduceWay = overpaymentReduceWay;
        return this;
    }
    public InputData withOverpaymentProvisionPercent(BigDecimal overpaymentProvisionPercent){
        this.overpaymentProvisionPercent = overpaymentProvisionPercent;
        return this;
    }
    public InputData withOverpaymentProvisionMonths(BigDecimal overpaymentProvisionMonths){
        this.overpaymentProvisionMonths = overpaymentProvisionMonths;
        return this;
    }

    public InputData withOverpaymentSchema(Map<Integer, BigDecimal> overpaymentSchema){
        this.overpaymentSchema = overpaymentSchema;
        return this;
    }

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

    public Map<Integer, BigDecimal> getOverpaymentSchema() {
        return overpaymentSchema;
    }

    public static BigDecimal getPERCENT() {
        return PERCENT;
    }

    public String getOverpaymentReduceWay() {
        return overpaymentReduceWay;
    }

    public BigDecimal getOverpaymentProvisionPercent() {
        return overpaymentProvisionPercent.divide(PERCENT, 4, RoundingMode.HALF_UP);
    }

    public BigDecimal getOverpaymentProvisionMonths() {
        return overpaymentProvisionMonths;
    }
}
