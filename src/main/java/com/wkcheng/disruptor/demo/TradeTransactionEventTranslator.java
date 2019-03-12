package com.wkcheng.disruptor.demo;

import com.lmax.disruptor.EventTranslator;

import java.util.Random;

/**
 * @author created by wkcheng@iflytek.com at 2018/11/14 14:04
 * @desc 生产者
 */
public class TradeTransactionEventTranslator implements EventTranslator<TradeTransaction> {

    private Random random=new Random();
    @Override
    public void translateTo(TradeTransaction event, long sequence) {
        this.generateTradeTransaction(event);
    }
    private TradeTransaction generateTradeTransaction(TradeTransaction trade){
        trade.setPrice(random.nextDouble()*9999);
        return trade;
    }

}
