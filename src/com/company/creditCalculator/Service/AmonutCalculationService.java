package com.company.creditCalculator.Service;

import com.company.creditCalculator.Model.InputData;
import com.company.creditCalculator.Model.Overpayment;
import com.company.creditCalculator.Model.Rate;
import com.company.creditCalculator.Model.RateAmounts;

public interface AmonutCalculationService {
    RateAmounts calculate(InputData inputData, Overpayment overpayment);

    RateAmounts calculate(InputData inputData, Overpayment overpayment, Rate previousRate);
}
