package com.wkcheng.multids;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author: created by ksymmy@163.com at 2019/8/20 16:06
 * @desc:
 */
@Aspect
public class SwitchDataSourceAspect {
    public SwitchDataSourceAspect() {
    }

    @Pointcut("@annotation(com.wkcheng.multids.SwitchDataSource)")
    public void switchDataSourcePointCut() {
    }

    @Before("switchDataSourcePointCut()")
    public void beforeSwitchDataSource(JoinPoint point) {
        Class<?> className = point.getTarget().getClass();
        String methodName = point.getSignature().getName();
        Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
        String dataSource = "";
        try {
            Method method = className.getMethod(methodName, argClass);
            if (method.isAnnotationPresent(SwitchDataSource.class)) {
                SwitchDataSource annotation = method.getAnnotation(SwitchDataSource.class);
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源
        DataSourceContextHolder.setDataSource(dataSource);
    }

    @After("switchDataSourcePointCut()")
    public void afterSwitchDataSource(JoinPoint point) {
        DataSourceContextHolder.clearDataSource();
    }
}
