package com.thoughtworks;

public enum Currency {
    RUPEE(1),
    USD(74.85);

    private final double factor;

    Currency(double factor) {
        this.factor = factor;
    }

    public double getConversionFactor() {
        return this.factor;
    }
}
