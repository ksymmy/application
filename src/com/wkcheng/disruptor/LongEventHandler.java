package com.wkcheng.disruptor;

/**
 * @author created by wkcheng@iflytek.com at 2018/9/18 20:57
 * @desc 定义事件处理的具体实现 通过实现接口 com.lmax.disruptor.EventHandler<T> 定义事件处理的具体实现。
 */

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> {
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) {
        System.out.println("receivedEvent: " + event);
    }
}