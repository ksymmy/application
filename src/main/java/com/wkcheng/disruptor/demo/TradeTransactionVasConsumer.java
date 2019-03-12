package com.wkcheng.disruptor.demo;

import com.lmax.disruptor.EventHandler;

/**
 * @author created by wkcheng@iflytek.com at 2018/11/14 14:03
 * @desc
 */
public class TradeTransactionVasConsumer implements EventHandler<TradeTransaction> {

    @Override
    public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {
        //do something....
    }
}