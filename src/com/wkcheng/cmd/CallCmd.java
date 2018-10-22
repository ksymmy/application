package com.wkcheng.cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author created by wkcheng@iflytek.com at 2018/8/22 16:39
 * @desc
 */

public class CallCmd {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            ping(i);
            Thread.sleep(1000);
        }
    }

    private static void ping(int i) {
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec("telnet ossptest.voicecloud.cn 99");
            br = new BufferedReader(new InputStreamReader(p.getInputStream(), "gbk"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            System.out.println(i + ":" + sb.toString());
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
