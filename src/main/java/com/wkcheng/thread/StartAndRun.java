package com.wkcheng.thread;

/**
 * @author: created by ksymmy@163.com at 2019/8/6 9:11
 * @desc:
 */
public class StartAndRun {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i + "-a" + Thread.currentThread().getName());
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i + "-b" + Thread.currentThread().getName());
                }
            }
        });

        thread1.start();
        thread1.run();
//        thread2.start();
//        thread2.run();

    }
}
