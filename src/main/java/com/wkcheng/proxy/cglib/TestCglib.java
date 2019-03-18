package com.wkcheng.proxy.cglib;

/**
 * @author created by wkcheng@iflytek.com at 2019/3/18 19:19
 * @desc
 */
public class TestCglib {
    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImpl bookFacade = (BookFacadeImpl) cglib.getInstance(new BookFacadeImpl());
        long i = bookFacade.addBook();
        System.out.println(i);
    }
}
