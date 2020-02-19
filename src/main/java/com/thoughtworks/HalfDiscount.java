package com.thoughtworks;

import com.thoughtworks.util.Utils;

public class HalfDiscount implements Discount {
    private double savePrice = 0;

    @Override
    public double calcPrice(Order order) {
        double totalPrice = 0;
        for (OrderData orderData : order.getDatas()) {
            double price = orderData.getDish().getPrice();
            for (String halfDishId : DataProvider.getHalfDishIds()) {
                if (orderData.getDish().getId().equals(halfDishId)) {
                    price = price / 2;
                    savePrice += price;
                    break;
                }
            }
            totalPrice += orderData.getNum() * price;
        }
        return totalPrice;
    }

    @Override
    public String getName() {
        if (savePrice == 0) {
            return "";
        }
        return String.format("-----------------------------------\n" +
                        "使用优惠:\n指定菜品半价(黄焖鸡，凉皮)，省%s元\n",
                Utils.convertDoubleToString(savePrice / 2));
    }
}
