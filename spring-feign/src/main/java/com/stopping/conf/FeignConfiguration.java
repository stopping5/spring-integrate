package com.stopping.conf;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * feign配置类
 * @Classname: FeignConfiguration
 * @Date: 2022/5/17 2:40 下午
 * @author: stopping
 */
@Configuration
public class FeignConfiguration implements RequestInterceptor {
    /**
     * 通过获取请求信息，获取token信息
     * 注入到requestTemplate.header feign头信息中
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String token = attributes.getRequest().getHeader("token");
        requestTemplate.header("token",token);
        System.out.println("feign token insert");
    }
}
