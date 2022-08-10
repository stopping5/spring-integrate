package com.stopping.orgincode.config;

import com.stopping.orgincode.annotion.ConditionalOnSystem;
import com.stopping.orgincode.pojo.MyConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用自定义条件配置
 * @Classname: ConditionConfig
 * @Date: 2022/5/30 10:43 上午
 * @author: stopping
 */
@Configuration
public class ConditionConfig {
    @Bean
    @ConditionalOnSystem(environment = "mac")
    public MyConfig myConfig(){
        return new MyConfig();
    }
}
