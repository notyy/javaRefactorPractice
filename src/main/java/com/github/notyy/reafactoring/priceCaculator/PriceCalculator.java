package com.github.notyy.reafactoring.priceCaculator;

public class PriceCalculator {
    public double getPrice(int quantity, double itemPrice) {
        double basePrice = quantity * itemPrice;
        double discountFactor;
        if(basePrice >= 1000){
            discountFactor = 0.80;
        }else {
            discountFactor = 0.90;
        }
        return basePrice * discountFactor;
    }

    public double complexPrice(int quantity, double itemPrice) {
        //price = base price - quantity discount + shipping
        return quantity * itemPrice - Math.max(0, quantity-500) * itemPrice * 0.05 +
                Math.min(quantity * itemPrice * 0.1, 100.0);
    }
}
