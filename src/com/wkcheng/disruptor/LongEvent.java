package com.wkcheng.disruptor;

import com.alibaba.fastjson.JSON;

/**
 * @author created by wkcheng@iflytek.com at 2018/9/18 20:55
 * @desc 定义事件 事件(Event)就是通过 Disruptor 进行交换的数据类型。
 * https://www.cnblogs.com/haiq/p/4112689.html
 */
public class LongEvent {

    private long value;

    public void setValue(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}