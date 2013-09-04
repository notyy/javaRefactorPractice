package com.github.notyy.reafactoring.owingPrinter;

public class OrderItem {
    private double amount = 0.0;

    public OrderItem(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
