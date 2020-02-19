package com.thoughtworks;

import com.thoughtworks.util.Utils;

public class FullDiscount implements Discount {
    private double savePrice = 0;

    @Override
    public double calcPrice(Order order) {
        double totalPrice = 0;
        for (OrderData orderData : order.getDatas()) {
            totalPrice += orderData.getNum() * orderData.getDish().getPrice();
        }
        savePrice = Math.floor(totalPrice / 30) * 6;
        return totalPrice - savePrice;
    }

    @Override
    public String getName() {
        return String.format("-----------------------------------\n" +
                        "使用优惠:\n满30减6元，省%s元\n",
                Utils.convertDoubleToString(savePrice));
    }
}
