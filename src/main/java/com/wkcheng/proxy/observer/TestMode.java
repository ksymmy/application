package com.wkcheng.proxy.observer;

/**
 * @author : wkcheng
 * @description:
 * @date : 2021/1/21 8:45
 **/
public class TestMode {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();

        Observer zs = new MyObserver(subject, "张三");
        Observer ls = new MyObserver(subject, "李四");
        Observer ww = new MyObserver(subject, "王五");

        subject.notifyObservers();
        subject.removeObserver(ls);
        Observer ml = new MyObserver(subject, "麻溜");
        subject.notifyObservers();
    }
}
