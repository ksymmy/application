package com.wkcheng.list;

import java.util.List;

/**
 * @author created by wkcheng@iflytek.com at 2018/6/27 9:38
 * @desc
 */
public class ReadThread implements Runnable {
    private List<Integer> list;

    public ReadThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println("--------------");
        for (Integer ele : list) {
            System.out.println("ReadThread:" + ele);
        }
        System.out.println("--------------");
    }
}
