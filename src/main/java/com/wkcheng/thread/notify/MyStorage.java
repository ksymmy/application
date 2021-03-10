package com.wkcheng.thread.notify;

import lombok.Data;

/**
 * @author: created by ksymmy@163.com at 2019/8/7 9:27
 * @desc:
 */
@Data
public class MyStorage {
    private char content;
    private volatile boolean flag = true;

    public synchronized void pushContent(char content) {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.content = content;
        System.out.println(this.content + " pushed by myProducer");
        this.flag = false;
        notify();
    }

    public synchronized char getContent() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.flag = true;
        System.out.println(this.content + " consumed by myConsumer");
        notify();
        return this.content;
    }
}
