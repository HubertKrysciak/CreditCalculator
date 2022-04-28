package com.company.creditCalculator.Service;

import com.company.creditCalculator.Model.InputData;
import com.company.creditCalculator.Model.Rate;

import java.util.List;

public interface RateCalculationService {
    List<Rate> calculate(final InputData inputData);
}
