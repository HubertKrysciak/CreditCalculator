package com.company.creditCalculator.Service;

import com.company.creditCalculator.Model.Rate;

import java.math.BigDecimal;

@FunctionalInterface
public interface Function {

    BigDecimal calculate(Rate rate);
}
