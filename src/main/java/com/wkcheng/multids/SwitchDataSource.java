package com.wkcheng.multids;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: created by ksymmy@163.com at 2019/8/20 15:58
 * @desc:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SwitchDataSource {
    String value() default "";
}
