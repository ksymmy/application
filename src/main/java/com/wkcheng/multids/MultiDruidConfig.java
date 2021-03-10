package com.wkcheng.multids;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: created by ksymmy@163.com at 2019/8/20 15:58
 * @desc:
 */

@Configuration
//@EnableConfigurationProperties({MultiDruidProperties.class})
public class MultiDruidConfig {
    @Autowired
    private MultiDruidProperties multiDruidProperties;

    @Bean
    public DataSource dataSource() {
        if (null == this.multiDruidProperties.getMulti() || this.multiDruidProperties.getMulti().isEmpty()) {
            throw new BeanCreationException("multids 配置错误");
        }
        MultiDataSource multipleDataSource = new MultiDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        DruidDataSource defaultDataSource = null;
        for (DruidProperties p : this.multiDruidProperties.getMulti()) {
            DruidDataSource datasource = new DruidDataSource();
            datasource.setUrl(p.getUrl());
            datasource.setUsername(p.getUsername());
            datasource.setPassword(p.getPassword());
            datasource.setDriverClassName(p.getDriverClassName());
            datasource.setInitialSize(p.getInitialSize());
            datasource.setMinIdle(p.getMinIdle());
            datasource.setMaxActive(p.getMaxActive());
            datasource.setMaxWait(p.getMaxWait());
            datasource.setTimeBetweenEvictionRunsMillis(p.getTimeBetweenEvictionRunsMillis());
            datasource.setMinEvictableIdleTimeMillis(p.getMinEvictableIdleTimeMillis());
            datasource.setValidationQuery(p.getValidationQuery());
            datasource.setTestWhileIdle(p.isTestWhileIdle());
            datasource.setTestOnBorrow(p.isTestOnBorrow());
            datasource.setTestOnReturn(p.isTestOnReturn());
            datasource.setPoolPreparedStatements(p.isPoolPreparedStatements());
            datasource.setMaxPoolPreparedStatementPerConnectionSize(p.getMaxPoolPreparedStatementPerConnectionSize());
            if (null != p.getFilters() && !"".equals(p.getFilters())) {
                try {
                    datasource.setFilters(p.getFilters());
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
            if (null != p.getConnectionProperties() && !"".equals(p.getConnectionProperties())) {
                datasource.setConnectionProperties(p.getConnectionProperties());
            }
            if (p.isPrimary()) {
                defaultDataSource = datasource;
            }
            String dsName = p.getDsName();
            if (Objects.isNull(dsName) || "".equals(dsName)) {
                dsName = p.getUrl();
            }
            targetDataSources.put(dsName, datasource);
        }
        if (null == defaultDataSource) {
            throw new BeanCreationException("请设置一个数据源作为主数据源");
        }
        // 添加数据源
        multipleDataSource.setTargetDataSources(targetDataSources);
        multipleDataSource.setDefaultTargetDataSource(defaultDataSource);
        return multipleDataSource;
    }

    @Bean
    public SwitchDataSourceAspect switchDataSourceAspect() {
        return new SwitchDataSourceAspect();
    }
}