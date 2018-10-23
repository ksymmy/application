package com.wkcheng.disruptor;

/**
 * @author created by wkcheng@iflytek.com at 2018/9/18 20:56
 * @desc 定义事件工厂
 */

import com.lmax.disruptor.EventFactory;

public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}