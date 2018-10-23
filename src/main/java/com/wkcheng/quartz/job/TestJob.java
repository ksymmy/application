package com.wkcheng.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author created by wkcheng@iflytek.com at 2018/10/23 8:47
 * @desc quartz 方式1, 继承 QuartzJobBean
 */
public class TestJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date());
    }
}
