package com.dm.springcloud.config;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
* @vlog: 高于生活，源于生活
* @desc: 类的描述:MyBatis配置类
* @author: smlz
* @createDate: 2019/12/9 20:24
* @version: 1.0
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
