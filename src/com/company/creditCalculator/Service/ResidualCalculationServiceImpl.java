package com.company.creditCalculator.Service;

import com.company.creditCalculator.Model.InputData;
import com.company.creditCalculator.Model.MortgageResidual;
import com.company.creditCalculator.Model.Rate;
import com.company.creditCalculator.Model.RateAmounts;

import java.math.BigDecimal;

public class ResidualCalculationServiceImpl implements ResidualCalculationService {
    @Override
    public MortgageResidual calculate(RateAmounts rateAmounts, InputData inputData) {
        BigDecimal residualAmount = inputData.getAmount().subtract(rateAmounts.getCapitalAmount());
        BigDecimal residualDuration = inputData.getDurationMonths().subtract(BigDecimal.ONE);

        return new MortgageResidual(residualAmount, residualDuration);
    }

    @Override
    public MortgageResidual calculate(RateAmounts rateAmounts, Rate previousRate) {
        BigDecimal residualAmount = previousRate.getMortgageResidual().getAmount().subtract(rateAmounts.getCapitalAmount());
        BigDecimal residualDuration = previousRate.getMortgageResidual().getDuration().subtract(BigDecimal.ONE);

        return new MortgageResidual(residualAmount, residualDuration);
    }
}
