package com.wkcheng.base.volatile_;

/**
 * @author created by wkcheng@iflytek.com at 2019/3/11 10:29
 * @desc https://blog.csdn.net/xiao__jia__jia/article/details/81013646
 */
// 使用 volatile 之前

public class TestVolatile {


    public static void main(String[] args) {

        ThreadDemo td = new ThreadDemo();

        new Thread(td).start();


        while (true) {

           synchronized (td){
               if (td.isFlag()) {

                   System.out.println("########");

                   break;

               }
           }

        }

    }

}


class ThreadDemo implements Runnable {

    private /*volatile*/ boolean flag = false;


    public void run() {

        try {

// 该线程 sleep(200), 导致了程序无法执行成功

            Thread.sleep(200);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }
        flag = true;
        System.out.println("flag=" + isFlag());

    }


    public boolean isFlag() {

        return flag;

    }


    public void setFlag(boolean flag) {

        this.flag = flag;

    }

}
