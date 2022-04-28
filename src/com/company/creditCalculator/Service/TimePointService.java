package com.company.creditCalculator.Service;

import com.company.creditCalculator.Model.InputData;
import com.company.creditCalculator.Model.TimePoint;

import java.math.BigDecimal;

public interface TimePointService {
    TimePoint calculate(BigDecimal rateNumber, InputData inputData);
}
