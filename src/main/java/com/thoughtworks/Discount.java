package com.thoughtworks;

public interface Discount {
    double calcPrice(Order order);
    String getName();
}
