package com.company.creditCalculator.Model;

import java.math.BigDecimal;

public class MorgageReference {

    private final BigDecimal referenceAmount;

    private final BigDecimal referenceDuration;

    public MorgageReference(BigDecimal referenceAmount, BigDecimal referenceDuration) {
        this.referenceAmount = referenceAmount;
        this.referenceDuration = referenceDuration;
    }

    public BigDecimal getReferenceAmount() {
        return referenceAmount;
    }

    public BigDecimal getReferenceDuration() {
        return referenceDuration;
    }
}
