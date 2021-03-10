package com.wkcheng.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author created by wkcheng@iflytek.com at 2019/3/20 12:43
 * @desc https://blog.csdn.net/qq_18860653/article/details/53406723
 * http://ifeve.com/overview/
 */
public class CopyFile {
    static public void main(String args[]) throws Exception {

        String infile = "C:\\Users\\think\\Desktop\\nio\\a.log";
        String outfile = "C:\\Users\\think\\Desktop\\nio\\b.log";

        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);
        // 获取读的通道
        FileChannel fcin = fin.getChannel();
        // 获取写的通道
        FileChannel fcout = fout.getChannel();
        // 定义缓冲区，并指定大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        long start = System.currentTimeMillis();
        while (true) {
            // 清空缓冲区
            buffer.clear();
            //从通道读取一个数据到缓冲区
            int r = fcin.read(buffer);
            //判断是否有从通道读到数据
            if (r == -1) {
                break;
            }
            //将buffer指针指向头部
            buffer.flip();
            //把缓冲区数据写入通道
            fcout.write(buffer);
        }
        fin.close();
        fout.close();
        System.out.println(System.currentTimeMillis() - start);


//        long start1 = System.currentTimeMillis();
//        RandomAccessFile inFile = new RandomAccessFile(new File(infile), "r");
//        RandomAccessFile outFile = new RandomAccessFile(new File(outfile), "rw");
//
//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = inFile.read(bytes)) != -1) {
//            outFile.write(bytes, 0, len);
//        }
//        inFile.close();
//        outFile.close();
//        System.out.println(System.currentTimeMillis() - start1);
    }

}
