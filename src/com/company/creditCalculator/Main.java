package com.company.creditCalculator;

import com.company.creditCalculator.Model.InputData;
import com.company.creditCalculator.Model.RateType;
import com.company.creditCalculator.Service.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        InputData inputData = new InputData();
        PrintingServiceImplementation printingServiceImplementation = new PrintingServiceImplementation();

        RateCalculationService rateCalculationService = new RateCalculationServiceImpl(new TimePointServiceImpl(), new AmountCalculationServiceImpl(), new OverpaymentCalculationServiceImpl(), new ResidualCalculationServiceImpl(), new ReferenceCalculationServiceImpl());
        MortgageCalculationService mortgageCalculationService = new MortgageCalculationServiceImpl(printingServiceImplementation, rateCalculationService, SummaryServiceFactory.create());
        mortgageCalculationService.calculate(inputData);


    }
}
