package com.wkcheng.proxy.staticproxy;

/**
 * @author created by wkcheng@iflytek.com at 2019/3/18 17:30
 * @desc
 */
public class TestCount {
    public static void main(String[] args) {
        CountImpl count = new CountImpl();

        CountProxy proxy = new CountProxy(count);

        proxy.queryCount();

        proxy.updateCount();
    }
}
