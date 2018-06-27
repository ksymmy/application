package com.wkcheng.list;

import java.util.List;

/**
 * @author created by wkcheng@iflytek.com at 2018/6/27 9:39
 * @desc
 */
public class WriteThread implements Runnable {
    private List<Integer> list;

    public WriteThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        this.list.add(9);
    }
}
