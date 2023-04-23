package com.stopping.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Classname: TestDatasourceConfig
 * @Description: test 数据源
 * @Date: 2023/4/21 4:24 下午
 * @author: stopping
 */
@Component
@Data
//@ConfigurationProperties(prefix = "spring.datasource.test")
public class TestDatasourceConfig {
    @Value("${spring.datasource.test.driverClass}")
    private String driverClass;
    @Value("${spring.datasource.test.url}")
    private String url;
    @Value("${spring.datasource.test.username}")
    private String username;
    @Value("${spring.datasource.test.password}")
    private String password;

    @Bean(name = "testDataSource")
    public DataSource testDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setReadOnly(false);
        //minimum number of idle connection
        config.setMinimumIdle(10);
        //maximum number of connection in the pool
        config.setMaximumPoolSize(100);
        //maximum wait milliseconds for get connection from pool
        config.setConnectionTimeout(60000);
        config.setIdleTimeout(20000);
        // max idle time for recycle idle connection
        config.setMaxLifetime(60000);
        //validation query timeout
        config.setValidationTimeout(3000);
        //create datasource
        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }
}
