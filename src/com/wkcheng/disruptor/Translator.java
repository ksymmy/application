package com.wkcheng.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

/**
 * @author created by wkcheng@iflytek.com at 2018/9/19 9:22
 * @desc
 */
public class Translator implements EventTranslatorOneArg<LongEvent, Long> {
    @Override
    public void translateTo(LongEvent event, long sequence, Long data) {
        event.setValue(data);
    }

    public static Translator TRANSLATOR = new Translator();

    public static void publishEvent2(Disruptor<LongEvent> disruptor) {
        // 发布事件；
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        long data = System.currentTimeMillis();//获取要通过事件传递的业务数据；
        ringBuffer.publishEvent(TRANSLATOR, data);
    }
}