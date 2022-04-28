package com.company.creditCalculator.Service;

import com.company.creditCalculator.Model.InputData;
import com.company.creditCalculator.Model.MortgageResidual;
import com.company.creditCalculator.Model.Rate;
import com.company.creditCalculator.Model.RateAmounts;

public interface ResidualCalculationService {
    MortgageResidual calculate(RateAmounts rateAmounts, InputData inputData);

    MortgageResidual calculate(RateAmounts rateAmounts, Rate previousRate);
}
