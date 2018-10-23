package com.wkcheng.list;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author created by wkcheng@iflytek.com at 2018/6/27 9:38
 * @desc https://blog.csdn.net/linsongbin1/article/details/54581787
 */
public class CopyOnWriteArrayListTest {
    private void test() {
        //1、初始化CopyOnWriteArrayList
        List<Integer> tempList = Arrays.asList(1, 2);
        CopyOnWriteArrayList<Integer> copyList = new CopyOnWriteArrayList<>(tempList);

        //2、模拟多线程对list进行读和写
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new ReadThread(copyList));
        executorService.execute(new WriteThread(copyList));
        executorService.execute(new WriteThread(copyList));
        executorService.execute(new WriteThread(copyList));
        executorService.execute(new ReadThread(copyList));
        executorService.execute(new WriteThread(copyList));
        executorService.execute(new ReadThread(copyList));
        executorService.execute(new WriteThread(copyList));

        System.out.println("copyList size:" + copyList.size());
    }


    public static void main(String[] args) {
        new CopyOnWriteArrayListTest().test();
    }
}
