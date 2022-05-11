package com.company.creditCalculator.Service;

import com.company.creditCalculator.Model.InputData;
import com.company.creditCalculator.Model.MorgageReference;
import com.company.creditCalculator.Model.Rate;

public class ReferenceCalculationServiceImpl implements ReferenceCalculationService {

    @Override
    public MorgageReference calculate(InputData inputData) {
        return new MorgageReference(inputData.getAmount(), inputData.getDurationMonths());
    }
}
