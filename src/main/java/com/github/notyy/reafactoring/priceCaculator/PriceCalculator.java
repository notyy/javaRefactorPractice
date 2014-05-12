package com.github.notyy.reafactoring.priceCaculator;

public class PriceCalculator {
    private final int quantity;
    private final double itemPrice;

    public PriceCalculator(int quantity, double itemPrice){
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double getPrice() {
        double basePrice = quantity * itemPrice;
        double discountFactor;
        if(quantity >= 1000){
            discountFactor = 0.80;
        }else {
            discountFactor = 0.90;
        }
        return basePrice * discountFactor;
    }

}
