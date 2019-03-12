package com.wkcheng.disruptor.demo;

import com.lmax.disruptor.EventHandler;

/**
 * @author created by wkcheng@iflytek.com at 2018/11/14 14:04
 * @desc
 */
public class TradeTransactionJMSNotifyHandler implements EventHandler<TradeTransaction> {
    @Override
    public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {

    }

}
