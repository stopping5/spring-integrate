package com.stopping.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * JDBC连接配置
 */
@Configuration
public class JdbcConfig {
    @Primary
    @Bean(name = "testJdbcTemplate")
    public JdbcTemplate testTemplate(@Qualifier(value = "testDateBase")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "userJdbcTemplate")
    public JdbcTemplate userTemplate(@Qualifier(value = "userDateBase")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
