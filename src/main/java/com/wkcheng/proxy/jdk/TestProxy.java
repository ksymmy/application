package com.wkcheng.proxy.jdk;

/**
 * @author created by wkcheng@iflytek.com at 2019/3/18 19:05
 * @desc
 */
public class TestProxy {

    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookProxy.addBook();
    }
}
