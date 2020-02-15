package com.thoughtworks;

public class OrderData {
    private int num;
    private Dish dish;

    public OrderData(int num, Dish dish) {
        this.num = num;
        this.dish = dish;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "num=" + num +
                ", dish=" + dish +
                '}';
    }
}
