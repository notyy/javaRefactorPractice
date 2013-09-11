package com.github.notyy.reafactoring.priceCaculator;

public class ComplexPriceCalculator {
    public ComplexPriceCalculator() {
    }

    public double complexPrice(int quantity, double itemPrice) {
        //price = base price - quantity discount + shipping
        return quantity * itemPrice - Math.max(0, quantity - 500) * itemPrice * 0.05 +
                Math.min(quantity * itemPrice * 0.1, 100.0);
    }
}