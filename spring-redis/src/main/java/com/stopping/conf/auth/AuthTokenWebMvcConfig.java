package com.stopping.conf.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 权限拦截器
 * @Classname: AuthTokenWebMvcConfig
 * @Date: 2022/5/17 2:30 下午
 * @author: stopping
 */
@Configuration
public class AuthTokenWebMvcConfig implements WebMvcConfigurer {
    @Resource
    private AuthTokenInterceptor authTokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(authTokenInterceptor);
        interceptorRegistration.addPathPatterns("/**");
    }
}
