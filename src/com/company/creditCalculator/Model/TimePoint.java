package com.company.creditCalculator.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TimePoint {
    private LocalDate date;
    private BigDecimal year;
    private BigDecimal month;

    public TimePoint(LocalDate date, BigDecimal year, BigDecimal month) {
        this.date = date;
        this.year = year;
        this.month = month;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getYear() {
        return year;
    }

    public BigDecimal getMonth() {
        return month;
    }

}
