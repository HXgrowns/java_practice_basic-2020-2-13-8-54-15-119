package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class OrderParser {
    public static Order parse(String selectItems) {
        List<OrderData> orderDatas = new ArrayList<>();
        String[] orderDataStrings = selectItems.split(",");
        for (String orderDataString : orderDataStrings) {
            String[] strs = orderDataString.split(" x ");
            for (Dish dish : DataProvider.getDishes()) {
                if (dish.getId().equals(strs[0])) {
                    OrderData orderData = new OrderData(Integer.parseInt(strs[1]), dish);
                    orderDatas.add(orderData);
                }
            }
        }
        Order order = new Order(orderDatas);
        return order;
    }
}
