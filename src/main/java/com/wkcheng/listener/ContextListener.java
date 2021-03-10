package com.wkcheng.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author: created by ksymmy@163.com at 2019/8/19 11:28
 * @desc: ContextListener 实现接口ServletContextListener
 */
public class ContextListener implements ServletContextListener {

    /**
     * 当前web应用的初始化
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("web contextInitialized ");
    }

    /**
     * 当前web应用的销毁
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("web contextDestroyed  ");
    }
}
