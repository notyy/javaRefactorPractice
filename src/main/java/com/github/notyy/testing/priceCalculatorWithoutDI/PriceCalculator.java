package com.github.notyy.testing.priceCalculatorWithoutDI;

import com.github.notyy.testing.common.DiscountDAO;
import com.github.notyy.testing.common.MessageSender;

public class PriceCalculator {

    private DiscountDAO discountDAO = new DiscountDAO();
    private MessageSender messageSender = new MessageSender();


    public double getPrice(int quantity, double itemPrice) {
        double basePrice = quantity * itemPrice;
        if(quantity < 100) {
            throw new IllegalArgumentException("quantity must be >= 100");
        }
        double discountFactor = discountDAO.findDiscount(basePrice);
        double resultPrice = basePrice * discountFactor;
        messageSender.send("resultPrice:"+resultPrice);
        return resultPrice;
    }

}
