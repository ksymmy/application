package com.wkcheng.proxy.cglib;

/**
 * @author created by wkcheng@iflytek.com at 2019/3/18 19:10
 * @desc
 */
public class BookFacadeImpl implements BookFacade {
    @Override
    public long addBook() {
        System.out.println("cglib 增加书");
        return System.currentTimeMillis();
    }
}
