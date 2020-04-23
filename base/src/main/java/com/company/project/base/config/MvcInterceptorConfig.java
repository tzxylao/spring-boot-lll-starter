package com.company.project.base.config;

import com.company.project.base.interceptor.ValidInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurationSupport{

    @Autowired
    private ValidInterceptor validInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(validInterceptor).addPathPatterns("/**")
        .excludePathPatterns("/swagger-ui.html","/v2/api-docs", "/swagger-resources/configuration/ui",
                "/swagger-resources");
        super.addInterceptors(registry);
    }
}