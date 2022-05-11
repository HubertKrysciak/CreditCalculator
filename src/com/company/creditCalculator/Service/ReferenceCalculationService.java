package com.company.creditCalculator.Service;

import com.company.creditCalculator.Model.InputData;
import com.company.creditCalculator.Model.MorgageReference;
import com.company.creditCalculator.Model.Rate;

public interface ReferenceCalculationService {

    MorgageReference calculate(InputData inputData);

}
