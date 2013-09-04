package com.github.notyy.reafactoring.owingPrinter;

import java.util.ArrayList;
import java.util.List;

public class OwingCaculator {

    private String name;
    private List<OrderItem> orderItems;

    public OwingCaculator(String name, List<OrderItem> orderItems){
        this.name = name;
        this.orderItems = orderItems;
    }

    public void printOwing() {
        //print logo
        System.out.println("********************");
        System.out.println("***customer owing***");
        System.out.println("********************");

        //calculate total
        double total = calculateTotal(orderItems);

        //print details
        System.out.println("name:" + name);
        System.out.println("amount:" + total);
    }

    private double calculateTotal(List<OrderItem> orderItems1) {
        double total = 0.0;
        for(OrderItem orderItem: orderItems1){
            total += orderItem.getAmount();
        }
        return total;
    }

    public static void main(String[] args){
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem(25.0));
        orderItems.add(new OrderItem(35.0));
        orderItems.add(new OrderItem(40.0));

        new OwingCaculator("notyy", orderItems).printOwing();
    }
}
