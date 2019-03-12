package com.wkcheng.disruptor.demo;

import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.CountDownLatch;

/**
 * @author created by wkcheng@iflytek.com at 2018/11/14 14:05
 * @desc
 */
public class TradeTransactionPublisher implements Runnable {
    Disruptor<TradeTransaction> disruptor;
    private CountDownLatch latch;
    private static int LOOP = 10000;//模拟一千万次交易的发生

    public TradeTransactionPublisher(CountDownLatch latch, Disruptor<TradeTransaction> disruptor) {
        this.disruptor = disruptor;
        this.latch = latch;
    }

    @Override
    public void run() {
        TradeTransactionEventTranslator tradeTranslator = new TradeTransactionEventTranslator();
        for (int i = 0; i < LOOP; i++) {
            disruptor.publishEvent(tradeTranslator);
        }
        latch.countDown();
    }

}
