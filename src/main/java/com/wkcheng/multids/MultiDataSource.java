package com.wkcheng.multids;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author: created by ksymmy@163.com at 2019/8/20 15:56
 * @desc:
 */
public class MultiDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
