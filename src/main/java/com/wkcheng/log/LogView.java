package com.wkcheng.log;

/**
 * @author created by wkcheng@iflytek.com at 2018/8/23 16:28
 * @desc
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 根据文件大小实时读取数据
 *
 * @author admin
 */
public class LogView {

    private long lastTimeFileSize = 0; //上次文件大小
    private static final Logger logger = LoggerFactory.getLogger(LogView.class);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

    ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

    public void realtimeShowLog(File logFile) {

        if (logFile == null) {
            throw new IllegalStateException("logFile can not be null");
        }

        //启动一个线程每2秒读取新增的日志信息
        exec.scheduleWithFixedDelay(() -> {
            //获得变化部分
           /* try {
                long len = logFile.length();
                if (len < lastTimeFileSize) {
                    logger.info("Log file was reset. Restarting logging from start of file.");
                    lastTimeFileSize = 0;
                } else {
                    //指定文件可读可写
                    RandomAccessFile randomFile = new RandomAccessFile(logFile, "rw");

                    //获取RandomAccessFile对象文件指针的位置，初始位置是0
                    System.out.println("RandomAccessFile文件指针的初始位置:" + lastTimeFileSize);

                    randomFile.seek(lastTimeFileSize);//移动文件指针位置

                    String tmp = "";
                    while ((tmp = randomFile.readLine()) != null) {
                        System.out.println("info : " + new String(tmp.getBytes("iso8859-1")));
                    }
                    lastTimeFileSize = randomFile.length();
                    randomFile.close();
                }

            } catch (Exception e) {
                //实时读取日志异常，需要记录时间和lastTimeFileSize 以便后期手动补充
                logger.error(dateFormat.format(new Date()) + " File read error, lastTimeFileSize: " + lastTimeFileSize);
            } finally {
                //将lastTimeFileSize 落地以便下次启动的时候，直接从指定位置获取
            }*/
            List<String> lastNLine = readLastNLine(logFile, 3);
            /*Iterator<String> iterator = lastNLine.iterator();
            RandomAccessFile file = null;
            try {
               file = new RandomAccessFile("mock.log", "rw");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                file.seek(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (iterator.hasNext()){
                try {
                    file.write(iterator.next().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            System.out.println(lastNLine);


        }, 0, 4, TimeUnit.SECONDS);

    }

    public void stop() {
        if (exec != null) {
            exec.shutdown();
            logger.info("file read stop ！");
        }
    }


    public static void main(String[] args) throws Exception {

        LogView view = new LogView();
        final File tmpLogFile = new File("mock.log");
        view.lastTimeFileSize = 0;
        view.realtimeShowLog(tmpLogFile);

//        RandomAccessFile file = new RandomAccessFile("mock.log", "rw");
//        file.setLength(1024);
    }

    /**
     * 读取文件最后N行
     * 输出的时候请逆序输出
     *
     * @param file
     * @param numRead
     * @return List<String>
     */
    public static List<String> readLastNLine(File file, long numRead) {
        List<String> result = new ArrayList<>();
        long count = 0;//定义行数
        if (!file.exists() || file.isDirectory() || !file.canRead()) {
            return null;
        }
        RandomAccessFile fileRead = null;
        try {
            fileRead = new RandomAccessFile(file, "r"); //用读模式
            long length = fileRead.length();//获得文件长度
            if (length == 0L) {//文件内容为空
                return result;
            } else {
                // 开始位置
                long pos = length - 1;
                while (pos > 0) {
                    pos--;
                    fileRead.seek(pos); // 开始读取
                    if (fileRead.readByte() == '\n') {//有换行符，则读取
                        String line = new String(fileRead.readLine().getBytes("ISO-8859-1"), "UTF-8");
                        result.add(line);
                        count++;
                        if (count == numRead) {//满足指定行数 退出。
                            break;
                        }
                    }
                }

                if (pos == 0) {
                    fileRead.seek(0);
                    result.add(new String(fileRead.readLine().getBytes("ISO-8859-1"), "UTF-8"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileRead != null) {
                try {
                    // 关闭资源
                    fileRead.close();
                } catch (Exception e) {
                }
            }
        }

        FileOutputStream outFile;
        try {
            Collections.reverse(result);
            outFile = new FileOutputStream(file);
            for (Iterator<String> i = result.iterator(); i.hasNext(); ) {
                outFile.write((i.next() + "\r").getBytes()); // 将ArrayList里的内容重新写回之前的文件
            }
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


}

