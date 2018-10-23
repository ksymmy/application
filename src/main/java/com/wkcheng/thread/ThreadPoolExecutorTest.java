package com.wkcheng.thread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author created by wkcheng@iflytek.com at 2018/5/21 9:44
 * @desc
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
//        testCachedThreadPool();
//        testFixedThreadPool();
//        testScheduledThreadPool();
        testSingleThreadExecutor();
    }


    /**
     * 创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。
     * 调用 execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
     * 因此，长时间保持空闲的线程池不会使用任何资源。
     */
    private static void testCachedThreadPool() {
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 5; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第" + index + "个线程" + Thread.currentThread().getName());
                }
            });
        }
    }

    /**
     * 创建一个指定工作线程数量的线程池。每当提交一个任务就创建一个工作线程，如果工作线程数量达到线程池初始的最大数，则将提交的任务存入到池队列中。
     * 由于设置最大线程数为3，所以在输出三个数后等待2秒后才继续输出。
     */
    private static void testFixedThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(new Date().toLocaleString() + "第" + index + "个线程" + Thread.currentThread().getName());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
        }
    }

    /**
     * corePoolSize - 池中所保存的线程数，即使线程是空闲的也包括在内。
     */
    private static void testScheduledThreadPool() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
       /* scheduledThreadPool.schedule(new Runnable(){
            @Override
            public void run() {
                System.out.println("延迟三秒");
            }
        }, 3, TimeUnit.SECONDS);*/

        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟1秒后每三秒执行一次");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }

    /**
     * 底层：FinalizableDelegatedExecutorService包装的ThreadPoolExecutor实例，corePoolSize为1；maximumPoolSize为1；keepAliveTime为0L；unit为：TimeUnit.MILLISECONDS；workQueue为：new LinkedBlockingQueue<Runnable>() 无解阻塞队列
     * 通俗：创建只有一个线程的线程池，且线程的存活时间是无限的；当该线程正繁忙时，对于新任务会进入阻塞队列中(无界的阻塞队列)
     * 适用：一个任务一个任务执行的场景
     */
    private static void testSingleThreadExecutor() {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 5; i++) {
            final int index = i;
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(new Date().toLocaleString() + "第" + index + "个线程 " + Thread.currentThread().getName());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
