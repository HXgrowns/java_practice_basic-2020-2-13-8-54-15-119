package com.thoughtworks;

import java.util.List;

public class NoneDiscount implements Discount {

    @Override
    public double calcPrice(Order order) {
        double totalPrice = 0;
        for (OrderData orderData : order.getDatas()) {
            totalPrice += orderData.getNum() * orderData.getDish().getPrice();
        }
        return totalPrice;
    }

    @Override
    public String getName() {
        return "";
    }

    public Discount bestDiscount(Order order, List<Discount> discounts) {
        double min = this.calcPrice(order);
        Discount minDiscount = this;
        for (Discount discount : discounts) {
            double totalPrice = discount.calcPrice(order);
            if (min > totalPrice) {
                min = totalPrice;
                minDiscount = discount;
            }
        }
        return minDiscount;
    }
}
