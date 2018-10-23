package com.wkcheng.producterconsumer;

import org.omg.CORBA.Object;

/**
 * @author created by wkcheng@iflytek.com at 2018/7/30 16:23
 * @desc
 */
public interface AbstractStorage {

    void consume(int num);

    void produce(int num);
}
