package com.github.notyy.testing.priceCalculatorWithoutSideEffect;

import com.github.notyy.testing.common.DiscountDAOUtil;
import com.github.notyy.testing.common.MessageSenderUtil;

public class PriceCalculator {

    public double getPrice(int quantity, double itemPrice) {
        checkQuantity(quantity);
        try {
            double discountFactor = DiscountDAOUtil.findDiscount(basePrice(quantity, itemPrice));
            double resultPrice = calcPrice(basePrice(quantity, itemPrice), discountFactor);
            MessageSenderUtil.send("resultPrice:" + resultPrice);
            return resultPrice;
        } catch (Exception ex) {
            MessageSenderUtil.send("error getting discountFactor");
            return -1;
        }
    }

    public double calcPrice(double basePrice, double discountFactor) {
        return basePrice * discountFactor;
    }

    public void checkQuantity(int quantity) {
        if (quantity < 100) {
            throw new IllegalArgumentException("quantity must be >= 100");
        }
    }

    public double basePrice(int quantity, double itemPrice) {
        return quantity * itemPrice;
    }

}
