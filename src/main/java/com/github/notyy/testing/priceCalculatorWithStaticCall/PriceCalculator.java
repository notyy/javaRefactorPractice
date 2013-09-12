package com.github.notyy.testing.priceCalculatorWithStaticCall;

import com.github.notyy.testing.common.DiscountDAOUtil;
import com.github.notyy.testing.common.MessageSenderUtil;

public class PriceCalculator {

    public double getPrice(int quantity, double itemPrice) {
        double basePrice = quantity * itemPrice;
        if (quantity < 100) {
            throw new IllegalArgumentException("quantity must be >= 100");
        }
        try {
            double discountFactor = DiscountDAOUtil.findDiscount(basePrice);
            double resultPrice = basePrice * discountFactor;
            MessageSenderUtil.send("resultPrice:" + resultPrice);
            return resultPrice;
        } catch (Exception ex) {
            MessageSenderUtil.send("error getting discountFactor");
            return -1;
        }
    }

}
