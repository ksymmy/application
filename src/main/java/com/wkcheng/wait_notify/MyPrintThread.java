package com.wkcheng.wait_notify;

/**
 * @author created by wkcheng@iflytek.com at 2018/10/17 10:07
 * @desc
 */
public class MyPrintThread extends Thread {

    private String name;

    private final Object prev;

    private final Object self;

    private MyPrintThread(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }


    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.println(name);
                    count--;
                    self.notify();
                }
                try {
                    if (0 == count) {
                        prev.notifyAll();
                    } else {
                        prev.wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        MyPrintThread pa = new MyPrintThread("A", c, a);
        MyPrintThread pb = new MyPrintThread("B", a, b);
        MyPrintThread pc = new MyPrintThread("C", b, c);

        new Thread(pa).start();
        Thread.sleep(10);
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);
    }
}
