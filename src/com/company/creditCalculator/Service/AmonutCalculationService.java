package com.company.creditCalculator.Service;

import com.company.creditCalculator.Model.InputData;
import com.company.creditCalculator.Model.Rate;
import com.company.creditCalculator.Model.RateAmounts;

public interface AmonutCalculationService {
    RateAmounts calculate(InputData inputData);

    RateAmounts calculate(InputData inputData, Rate previousRate);
}
