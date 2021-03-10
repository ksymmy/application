package com.wkcheng.thread.notify;

/**
 * @author: created by ksymmy@163.com at 2019/8/7 9:34
 * @desc:
 */
public class MyProducer extends Thread {
    private final MyStorage ms;

    public MyProducer(MyStorage ms) {
        this.ms = ms;
    }

    @Override
    public void run() {
        for (char c = 'A'; c <= 'Z'; c++) {
            ms.pushContent(c);
        }
    }
}
