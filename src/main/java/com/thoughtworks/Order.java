package com.thoughtworks;

import java.util.List;

public class Order {
    private List<OrderData> datas;
    private Discount bestDiscount;

    public Discount getBestDiscount() {
        return bestDiscount;
    }

    public void setBestDiscount(Discount bestDiscount) {
        this.bestDiscount = bestDiscount;
    }

    public Order(List<OrderData> datas) {
        this.datas = datas;
    }

    public List<OrderData> getDatas() {
        return datas;
    }

    public void setDatas(List<OrderData> datas) {
        this.datas = datas;
    }
}
