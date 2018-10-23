package com.wkcheng.sqlite;

import com.almworks.sqlite4java.SQLiteQueue;

import java.io.File;

/**
 * @author created by wkcheng@iflytek.com at 2018/7/30 18:28
 * @desc http://repo.gradle.org/gradle/libs/com/almworks/sqlite4java/sqlite4java-win32-x64/1.0.392/
 */
public class Mainapp {
    public static void main(String[] args) {
        System.load("C:\\Users\\think\\Downloads\\sqlite4java-win32-x64-1.0.392.dll");
        SQLiteQueue myQueue = new SQLiteQueue(new File("C:\\Users\\think\\Desktop\\stp.db"));
        myQueue.start();

        //主线程一定要建立唯一的   SQLiteQueue，这个队列已经打开好数据库，在myQueue.start()后，就在其他任何线程可以往队列里加入数据库操作(SQLiteJob)，当然主线程也是可以的。

        Sql_thread sql_thread1 = new Sql_thread(myQueue);
        Thread t1 = new Thread(sql_thread1);

        Sql_thread sql_thread2 = new Sql_thread(myQueue);
        Thread t2 = new Thread(sql_thread2);

        Sql_thread sql_thread3 = new Sql_thread(myQueue);
        Thread t3 = new Thread(sql_thread3);


        //******启动线程

        t1.start();
        t2.start();
        t3.start();
    }
}
