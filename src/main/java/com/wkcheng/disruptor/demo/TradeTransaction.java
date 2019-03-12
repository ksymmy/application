package com.wkcheng.disruptor.demo;

/**
 * @author created by wkcheng@iflytek.com at 2018/11/14 14:01
 * @desc https://blog.csdn.net/qian_348840260/article/details/38321371
 */
public class TradeTransaction {
    private String id; //交易ID
    private double price;//交易金额

    public TradeTransaction() {
    }

    public TradeTransaction(String id, double price) {
        super();
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
