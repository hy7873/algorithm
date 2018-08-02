package com.zhongying.demo.util.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by Administrator on 2018/7/30.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("此时获取到的数据源为："+DataSourceContextHolder.getDbType());
        return DataSourceContextHolder.getDbType();
    }
}
