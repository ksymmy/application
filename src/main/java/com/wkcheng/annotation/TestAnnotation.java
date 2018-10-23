package com.wkcheng.annotation;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.testng.annotations.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author created by wkcheng@iflytek.com at 2018/8/3 8:58
 * @desc
 */
public class TestAnnotation<T> {
    private Class<T> entityClass;

    public TestAnnotation() {

        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        ParameterizedType pt = (ParameterizedType) demo.getClass().getGenericSuperclass();
        Class clazz = (Class) pt.getActualTypeArguments()[0];
        System.out.println(clazz);

        boolean annotationPresent = demo.getClass().isAnnotationPresent(Test.class);
        System.out.println(annotationPresent);


        clazz = GenericsUtils.getSuperClassGenricType(demo.getClass());

        System.out.println(clazz);


    }

    @Logger
    @Test
    static class Demo extends TestAnnotation<Boolean> {

    }
}
