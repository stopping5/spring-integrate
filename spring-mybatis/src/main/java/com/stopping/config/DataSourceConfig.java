package com.stopping.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据源配置
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "testDataBaseProperties")
    @ConfigurationProperties(prefix = "spring.datasource.test-database")
    public DataSourceProperties testDataResource(){
        return new DataSourceProperties();
    }

    @Bean(name = "testDateBase")
    @Primary
    public DataSource testDateBase(@Qualifier("testDataBaseProperties")DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }


    @Bean(name = "userDataBaseProperties")
    @ConfigurationProperties(prefix = "spring.datasource.user-database")
    public DataSourceProperties userDataResource(){
        return new DataSourceProperties();
    }

    @Bean(name = "userDateBase")
    public DataSource userDateBase(@Qualifier("userDataBaseProperties")DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
}
