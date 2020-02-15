package com.thoughtworks;

import java.util.Arrays;

public class Restaurant {

    public String bestCharge(String selectedItems) {
        Order order = OrderParser.parse(selectedItems);
        NoneDiscount noneDiscount = new NoneDiscount();
        HalfDiscount halfDiscount = new HalfDiscount();
        FullDiscount fullDiscount = new FullDiscount();
        Discount bestDiscount = noneDiscount.bestDiscount(order, Arrays.asList(halfDiscount, fullDiscount));
        order.setBestDiscount(bestDiscount);
        return OrderRender.render(order);
    }
}
