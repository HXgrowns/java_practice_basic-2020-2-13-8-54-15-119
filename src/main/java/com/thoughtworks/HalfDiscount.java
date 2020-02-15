package com.thoughtworks;

import com.thoughtworks.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class HalfDiscount implements Discount {
    private double savePrice = 0;
    private List<String> saveNames = new ArrayList<>();

    @Override
    public double calcPrice(Order order) {
        double totalPrice = 0;
        for (OrderData orderData : order.getDatas()) {
            double price = orderData.getDish().getPrice();
            for (String halfDishId : DataProvider.getHalfDishIds()) {
                if (orderData.getDish().getId().equals(halfDishId)) {
                    price = price / 2;
                    saveNames.add(orderData.getDish().getName());
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
        return String.format("-----------------------------------\n" +
                        "使用优惠:\n指定菜品半价(%s)，省%s元\n",
                saveNames.toString().replace("[", "").replace("]", "").replace(", ", "，"),
                Utils.dealDoule(savePrice));
    }
}
