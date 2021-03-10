package com.wkcheng.thread.notify;

/**
 * @author: created by ksymmy@163.com at 2019/8/7 9:37
 * @desc:
 */
public class MyConsumer extends Thread {
    private final MyStorage ms;

    public MyConsumer(MyStorage ms) {
        this.ms = ms;
    }

    @Override
    public void run() {
        char c;
        do {
            c = ms.getContent();
        } while (c != 'Z');
    }
}
