package com.company.creditCalculator.Service;

import com.company.creditCalculator.Model.InputData;
import com.company.creditCalculator.Model.Rate;
import com.company.creditCalculator.Model.Summary;

import java.util.Date;
import java.util.List;

public class PrintingServiceImplementation implements PrintingService{

    @Override
    public void printInputDataInfo(InputData inputData) {
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(MORTGAGE_AMOUNT).append(inputData.getAmount()).append(CURRENCY);
        msg.append(NEW_LINE);
        msg.append(MORTGAGE_PERIOD).append(inputData.getDurationMonths()).append(MONTHS);
        msg.append(NEW_LINE);
        msg.append(INTEREST).append(inputData.getInterestDisplay()).append(PERCENT);
        msg.append(NEW_LINE);
        printMessage(msg);
    }

    @Override
    public void printRates(List<Rate> calculate) {
            String format = "%8s %8s " +
                    "%8s %8s " +
                    "%8s %8s " +
                    "%8s %8s " +
                    "%8s %8s " +
                    "%8s %8s " +
                    "%8s %8s " +
                    "%8s %8s " +
                    "%8s %8s ";

        for (Rate rate : calculate) {
            String message = String.format(format,
                    RATE_NUMBER, rate.getRateNumber(),
                    DATE, rate.getTimePoint().getDate(),
                    YEAR, rate.getTimePoint().getYear(),
                    MONTH, rate.getTimePoint().getMonth(),
                    RATE, rate.getRateAmounts().getRateAmount(),
                    INTEREST, rate.getRateAmounts().getInterestAmount(),
                    CAPITAL, rate.getRateAmounts().getCapitalAmount(),
                    LEFT, rate.getMortgageResidual().getAmount(),
                    MONTHS, rate.getMortgageResidual().getDuration());

            System.out.println(message);

            if((int)rate.getTimePoint().getMonth().intValue() % 12 == 0){
                System.out.println();
            }
        }

    }

    @Override
    public void printSummary(Summary summary) {
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(INTEREST_SUM).append(summary.getInterestSum()).append(CURRENCY);
        msg.append(NEW_LINE);

        printMessage(msg);
    }

    private void printMessage(StringBuilder sb){
        System.out.println(sb);
    }
}
