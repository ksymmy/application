package com.wkcheng.quartz.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author created by wkcheng@iflytek.com at 2018/10/23 8:59
 * @desc 方式2
 */
public class TestJob2 {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public void doSomething() {
        logger.info("当前时间:{}", new Date().toLocaleString());
    }
}