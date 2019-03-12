package com.wkcheng.disruptor.demo;

import com.lmax.disruptor.EventHandler;

import java.util.UUID;

/**
 * @author created by wkcheng@iflytek.com at 2018/11/14 14:02
 * @desc 事件处理器(消费者)
 */
public class TradeTransactionInDBHandler implements EventHandler<TradeTransaction> {
    @Override
    public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {
        this.onEvent(event);
    }

    public void onEvent(TradeTransaction event) throws Exception {
        event.setId(UUID.randomUUID().toString());
        System.out.println(event.getId());

    }

}
