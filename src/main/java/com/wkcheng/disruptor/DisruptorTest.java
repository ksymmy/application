package com.wkcheng.disruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author created by wkcheng@iflytek.com at 2018/9/18 20:57
 * @desc
 */
public class DisruptorTest {

//    WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
//    WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
//    WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();

    @Test
    private void test() {
        EventFactory<LongEvent> eventFactory = new LongEventFactory();
        ExecutorService executors = Executors.newSingleThreadExecutor();
        int ringBufferSize = 1024 * 1024; // RingBuffer 大小，必须是 2 的 N 次方；
        //创建一个disruptor，指定ringbuffer的size和处理数据的factory
        Disruptor<LongEvent> disruptor = new Disruptor<>(eventFactory, ringBufferSize, executors, ProducerType.SINGLE, new YieldingWaitStrategy());

        //disruptor里面设置一个处理方式
        disruptor.handleEventsWith(new LongEventHandler());

        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        for (long i = 0; i < 1000; i++) {
            //下一个可以用的序列号
            long seq = ringBuffer.next();
            try {
                //这个序列号的slot 放入数据
                LongEvent valueEvent = ringBuffer.get(seq);
                valueEvent.setValue(i);
            } finally {
                //发布通知，并且这一步一定要放在finally中，因为调用了ringBuffer.next(),就一定要发布，否则会导致disruptor状态的错乱
                ringBuffer.publish(seq);
            }
        }

//        Translator.publishEvent2(disruptor);

        disruptor.shutdown();
        executors.shutdown();
    }
}
