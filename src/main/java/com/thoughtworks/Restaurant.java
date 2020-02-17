package com.thoughtworks;

import java.util.Arrays;
import java.util.List;

public class Restaurant {

    public String bestCharge(String selectedItems) {
        Order order = OrderParser.parse(selectedItems);
        NoneDiscount noneDiscount = new NoneDiscount();
        HalfDiscount halfDiscount = new HalfDiscount();
        FullDiscount fullDiscount = new FullDiscount();
        Discount bestDiscount = bestDiscount(order, Arrays.asList(halfDiscount, fullDiscount));
        order.setBestDiscount(bestDiscount);
        return OrderRender.render(order);
    }

    public Discount bestDiscount(Order order, List<Discount> discounts) {
        double minSpend = discounts.get(0).calcPrice(order);
        Discount minSpendMethod = discounts.get(0);
        for (Discount discount : discounts) {
            double totalPrice = discount.calcPrice(order);
            if (minSpend > totalPrice) {
                minSpend = totalPrice;
                minSpendMethod = discount;
            }
        }
        return minSpendMethod;
    }
}