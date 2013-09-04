package com.github.notyy.reafactoring.priceCaculator;

public class PriceCaculator {
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
}
