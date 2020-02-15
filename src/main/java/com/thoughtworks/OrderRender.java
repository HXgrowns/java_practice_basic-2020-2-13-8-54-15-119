package com.thoughtworks;

import com.thoughtworks.util.Utils;

public class OrderRender {
    public static String render(Order order) {
        String result = String.format("============= 订餐明细 =============\n");
        for (OrderData data : order.getDatas()) {
            result += String.format("%s x %d = %s元\n",
                    data.getDish().getName(), data.getNum(),
                    Utils.dealDoule(data.getDish().getPrice() * data.getNum()));
        }
        result += order.getBestDiscount().getName();
        result += String.format("-----------------------------------\n" +
                "总计：%s元\n" +
                "===================================", Utils.dealDoule(order.getBestDiscount().calcPrice(order)));
        return result;
    }
}
