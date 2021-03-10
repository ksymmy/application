package com.wkcheng.thread.notify;

/**
 * @author: created by ksymmy@163.com at 2019/8/7 9:39
 * @desc:
 */
public class Test {
    public static void main(String[] args) {
        MyStorage ms = new MyStorage();
        new MyProducer(ms).start();
        new MyConsumer(ms).start();
    }
}
