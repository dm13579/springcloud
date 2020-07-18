package com.dm.springcloud.config;

import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * MyBatis配置类
 */
@Configuration
public class MyBatisConfig {

    /**
     * 构造datasource代理对象，替换原来的datasource
     *
     * @param dataSource
     * @return
     */
    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }

}
