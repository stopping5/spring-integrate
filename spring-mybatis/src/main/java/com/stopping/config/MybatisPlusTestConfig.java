package com.stopping.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Classname: MybatisPlusTestConfig
 * @Description:  MBP配置
 * @Date: 2023/4/21 4:27 下午
 * @author: stopping
 */
@Configuration
@MapperScan(basePackages = "com.stopping.dao.mapper.test",sqlSessionFactoryRef = "testSqlSessionFactory")
public class MybatisPlusTestConfig {

    @Bean(name = "testSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("testDataSource")DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setTypeAliasesPackage("com.stopping.pojo.entity");
        //扫描对应数据源下mapper.xml url
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/test/*.xml"));
        return sessionFactoryBean.getObject();
    }

    @Bean("testTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("testDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
