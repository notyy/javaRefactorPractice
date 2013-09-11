package com.github.notyy.testing.priceCalculatorWithStaticCall;

import com.github.notyy.testing.common.DiscountDAOUtil;
import com.github.notyy.testing.common.MessageSenderUtil;

public class PriceCalculator {

    public double getPrice(int quantity, double itemPrice) {
        double basePrice = quantity * itemPrice;
        if(quantity < 100) {
            throw new IllegalArgumentException("quantity must be >= 100");
        }
        double discountFactor = DiscountDAOUtil.findDiscount(basePrice);
        double resultPrice = basePrice * discountFactor;
        MessageSenderUtil.send("result:"+resultPrice);
        return resultPrice;
    }

}
