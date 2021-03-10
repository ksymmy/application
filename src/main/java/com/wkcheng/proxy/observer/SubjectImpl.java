package com.wkcheng.proxy.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wkcheng
 * @description:
 * @date : 2021/1/21 8:40
 **/
public class SubjectImpl implements Subject {
    /**
     * 创建一个集合，管理观察者
     */
    private List<Observer> observers;

    public SubjectImpl() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = this.observers.indexOf(observer);
        if (index >= 0) {
            this.observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer item : observers) {
            item.doSomething();
        }
    }
}
