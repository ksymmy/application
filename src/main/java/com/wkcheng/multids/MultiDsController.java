package com.wkcheng.multids;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author: created by ksymmy@163.com at 2019/8/21 10:27
 * @desc:
 */
@RestController
@RequestMapping("/multi-ds")
public class MultiDsController {

    @Autowired
    DataSource dataSource;

    @RequestMapping("/base")
    @SwitchDataSource("base")
    public String testBase() {
        System.out.println(111);
        return DataSourceContextHolder.getDataSource();
    }

    @RequestMapping("/financing")
    @SwitchDataSource("financing")
    public String testFinancing() {
        return DataSourceContextHolder.getDataSource();
    }
}
