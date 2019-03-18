package com.wkcheng.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author created by wkcheng@iflytek.com at 2019/3/18 19:10
 * @desc
 */
public class BookFacadeCglib implements MethodInterceptor {
    public Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }


    //回调方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开始");
        Object rel = methodProxy.invokeSuper(o, objects);
        System.out.println("事务结束");
        return rel;
    }
}
