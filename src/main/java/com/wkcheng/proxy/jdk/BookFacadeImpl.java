package com.wkcheng.proxy.jdk;

/**
 * @author created by wkcheng@iflytek.com at 2019/3/18 18:59
 * @desc
 */
public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("增加书");
    }
}
