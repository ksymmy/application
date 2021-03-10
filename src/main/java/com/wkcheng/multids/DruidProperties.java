package com.wkcheng.multids;

import lombok.Data;

/**
 * @author: created by ksymmy@163.com at 2019/8/20 15:51
 * @desc:
 */
@Data
public class DruidProperties {

    private String dsName;
    private boolean primary;
    // ------必填项目------
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    // ------选填项目 ------

    // 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
    private String filters;
    // 通过connectProperties属性来打开mergeSql功能；慢SQL记录
    private String connectionProperties;
    // 用来检测连接是否有效的sql，要求是一个查询语句，常用select 'x'。
    // 如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会启作用。
    private String validationQuery = "SELECT 'x' FROM DUAL";
    // 初始化大小
    private int initialSize = 10;
    // 最小
    private int minIdle = 10;
    // 最大
    private int maxActive = 20;
    // 获取连接等待超时的时间
    private int maxWait = 50000;
    // 连接保持空闲而不被驱逐的最长时间
    private int minEvictableIdleTimeMillis = 300000;
    // 间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    private int timeBetweenEvictionRunsMillis = 90000;
    // 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
    private boolean testOnBorrow = false;
    // 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
    private boolean testOnReturn = false;
    // 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，
    // 如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效
    private boolean testWhileIdle = true;
    // 打开PSCache
    private boolean poolPreparedStatements = true;
    // 要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。
    // 在Druid中，不会存在Oracle下PSCache占用内存过多的问题
    private int maxPoolPreparedStatementPerConnectionSize = 20;
}
