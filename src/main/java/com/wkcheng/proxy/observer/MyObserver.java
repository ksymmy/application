package com.wkcheng.proxy.observer;

/**
 * @author : wkcheng
 * @description:
 * @date : 2021/1/21 8:44
 **/
public class MyObserver implements Observer {
    private Subject subject;
    private String name;

    MyObserver(Subject subject, String name) {
        this.subject = subject;
        this.subject.registerObserver(this);
        this.name = name;
    }

    @Override
    public void doSomething() {
        System.out.println("我是" + name + ",马上来取奶...");
    }
}
