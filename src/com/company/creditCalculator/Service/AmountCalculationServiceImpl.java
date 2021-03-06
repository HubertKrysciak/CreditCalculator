package com.company.creditCalculator.Service;

import com.company.creditCalculator.Model.InputData;
import com.company.creditCalculator.Model.Overpayment;
import com.company.creditCalculator.Model.Rate;
import com.company.creditCalculator.Model.RateAmounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AmountCalculationServiceImpl implements AmonutCalculationService {

    private static final BigDecimal YEAR = BigDecimal.valueOf(12);

    @Override
    public RateAmounts calculate(InputData inputData, Overpayment overpayment) {
        switch (inputData.getRateType()){
            case CONSTANT:
                return calculateConstantRate(inputData, overpayment);
            case DECREASING:
                return calculateDecreasingRate(inputData, overpayment);
        }
        return null;
    }

    @Override
    public RateAmounts calculate(InputData inputData, Overpayment overpayment, Rate previousRate) {
        switch (inputData.getRateType()){
            case CONSTANT:
                return calculateConstantRate(inputData, overpayment, previousRate);
            case DECREASING:
                return calculateDecreasingRate(inputData, overpayment, previousRate);
        }
        return null;
    }
    private RateAmounts calculateConstantRate(InputData inputData, Overpayment overpayment) {
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal residualAmount = inputData.getAmount();
        BigDecimal q = calculateQ(interestPercent);


        BigDecimal rateAmount = calculateConstantRateAmount(q, inputData.getAmount(), inputData.getDurationMonths());
        BigDecimal interestAmount = calculateInterestAmonut(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateConstantCapitalAmount(rateAmount, interestAmount);

        return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
    }

    private RateAmounts calculateConstantRate(InputData inputData, Overpayment overpayment, Rate previousRate) {
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal residualAmount = previousRate.getMortgageResidual().getAmount();
        BigDecimal q = calculateQ(interestPercent);

        BigDecimal rateAmount = calculateConstantRateAmount(q, inputData.getAmount(), inputData.getDurationMonths());
        BigDecimal interestAmount = calculateInterestAmonut(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateConstantCapitalAmount(rateAmount, interestAmount);

        return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
    }

    private BigDecimal calculateQ(BigDecimal interestPercent) {
        return interestPercent.divide(YEAR, 10, RoundingMode.HALF_UP).add(BigDecimal.ONE);
    }

    private RateAmounts calculateDecreasingRate(InputData inputData, Overpayment overpayment) {
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal residualAmount = inputData.getAmount();

        BigDecimal interestAmount = calculateInterestAmonut(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateDecreasingCapitalAmount(residualAmount, inputData.getDurationMonths());
        BigDecimal rateAmount = capitalAmount.add(interestAmount);
        
        return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
    }

    private RateAmounts calculateDecreasingRate(InputData inputData, Overpayment overpayment, Rate previousRate) {
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal residualAmount = previousRate.getMortgageResidual().getAmount();

        BigDecimal interestAmount = calculateInterestAmonut(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateDecreasingCapitalAmount(inputData.getAmount(), inputData.getDurationMonths());
        BigDecimal rateAmount = capitalAmount.add(interestAmount);
        
        return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
    }

    private BigDecimal calculateConstantRateAmount(BigDecimal q, BigDecimal amount, BigDecimal durationMonths) {
        return amount
                .multiply(q.pow(durationMonths.intValue()))
                .multiply(q.subtract(BigDecimal.ONE))
                .divide(q.pow(durationMonths.intValue()).subtract(BigDecimal.ONE), 50, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateInterestAmonut(BigDecimal residualAmount, BigDecimal interestPercent) {
        return residualAmount.multiply(interestPercent).divide(YEAR, 50, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateConstantCapitalAmount(BigDecimal rateAmount, BigDecimal interestAmount) {
        return rateAmount.subtract(interestAmount);
    }

    private BigDecimal calculateDecreasingCapitalAmount(BigDecimal amount, BigDecimal durationMonths) {
        return amount.divide(durationMonths,50, RoundingMode.HALF_UP);
    }
}
