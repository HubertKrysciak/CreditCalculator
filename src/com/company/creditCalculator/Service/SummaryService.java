package com.company.creditCalculator.Service;

import com.company.creditCalculator.Model.Rate;
import com.company.creditCalculator.Model.Summary;

import java.util.List;

public interface SummaryService {

    Summary calculate(List<Rate> rates);

}
