package com.company.creditCalculator.Service;

import com.company.creditCalculator.Model.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class RateCalculationServiceImpl implements RateCalculationService {

    private final TimePointService timePointService;

    private final AmonutCalculationService amonutCalculationService;

    private final ResidualCalculationService residualCalculationService;

    public RateCalculationServiceImpl(TimePointService timePointService, AmonutCalculationService amonutCalculationService, ResidualCalculationService residualCalculationService) {
        this.timePointService = timePointService;
        this.amonutCalculationService = amonutCalculationService;
        this.residualCalculationService = residualCalculationService;
    }

    @Override
    public List<Rate> calculate(InputData inputData) {
        List<Rate> rates = new LinkedList<>();
        BigDecimal rateNumber = BigDecimal.ONE;
        Rate firstRate = calculateRate(rateNumber, inputData);
        rates.add(firstRate);
        Rate previousRate = firstRate;

        for (BigDecimal index = rateNumber.add(BigDecimal.ONE);
             index.compareTo(inputData.getDurationMonths()) <= 0;
             index = index.add(BigDecimal.ONE)){
            Rate nextRate = calculateRate(index, inputData, previousRate);
            rates.add(nextRate);
            previousRate = nextRate;

        }

        return rates;
    }

    private Rate calculateRate(BigDecimal rateNumber, InputData inputData) {
        TimePoint timePoint = timePointService.calculate(rateNumber, inputData);
        RateAmounts rateAmounts = amonutCalculationService.calculate(inputData);
        MortgageResidual mortgageResidual = residualCalculationService.calculate(rateAmounts, inputData);
        return new Rate(timePoint, rateNumber, rateAmounts, mortgageResidual);
    }

    private Rate calculateRate(BigDecimal rateNumber, InputData inputData, Rate previousRate) {
        TimePoint timePoint = timePointService.calculate(rateNumber, inputData);
        RateAmounts rateAmounts = amonutCalculationService.calculate(inputData, previousRate);
        MortgageResidual mortgageResidual = residualCalculationService.calculate(rateAmounts, previousRate);
        return new Rate(timePoint, rateNumber, rateAmounts, mortgageResidual);
    }
}
