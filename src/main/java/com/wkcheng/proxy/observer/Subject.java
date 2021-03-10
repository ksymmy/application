package com.wkcheng.proxy.observer;

/**
 * @author : wkcheng
 * @description:
 * @date : 2021/1/21 8:35
 **/
public interface Subject {

    /**
     * register
     *
     * @param observer observer
     */
    void registerObserver(Observer observer);

    /**
     * remove
     *
     * @param observer observer
     */
    void removeObserver(Observer observer);

    /**
     * notify
     */
    void notifyObservers();
}
