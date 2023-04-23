package com.stopping.config;

import com.stopping.pojo.entity.Tag;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Classname: TestProperties
 * @Description: TODO
 * @Date: 2023/4/21 5:14 下午
 * @author: stopping
 */
@Component
@Data
@ConfigurationProperties(prefix = "feign.user")
public class TestProperties {
    private String url;

    private String name;

    @Bean("mytag")
    public Tag tag(){
        Tag tag = new Tag();
        tag.setValue(name);
        tag.setKey(url);
        return tag;
    }
}
