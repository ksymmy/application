package com.wkcheng.proxy.staticproxy;

/**
 * @author created by wkcheng@iflytek.com at 2019/3/18 17:13
 * @desc
 */
public class CountImpl implements Count {
    @Override
    public void queryCount() {
        System.out.println("查看账户方法...");
    }

    @Override
    public void updateCount() {
        System.out.println("修改账户方法...");
    }
}
