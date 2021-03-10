package com.wkcheng.multids;

/**
 * @author: created by ksymmy@163.com at 2019/8/20 15:50
 * @desc:
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public DataSourceContextHolder() {
    }

    public static void setDataSource(String ds) {
        contextHolder.set(ds);
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}
