package com.company.project.producerserviceimpl.business.clazz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: laoliangliang
 * @description: 例子通用业务 001
 * @create: 2020/4/20 11:46
 **/
@Component
@ConfigurationProperties(prefix = "nacos")
public class Business001 {

    /**
     * 简单配置例子
     */
    private String version;

    @Value("user.name")
    private String name;

    public String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }
}
