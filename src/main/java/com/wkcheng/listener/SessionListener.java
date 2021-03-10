package com.wkcheng.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author: created by ksymmy@163.com at 2019/8/19 11:35
 * @desc:
 */
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent e) {
        System.out.println("sessionCreated, sessionId ： " + e.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        System.out.println("sessionDestroyed, sessionId ： " + e.getSession().getId());
    }
}
