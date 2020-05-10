package com.company.project.orderserviceimpl.business.clazz;

import com.company.project.base.business.IBusinessAfter;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.log.ILogAfter;
import lombok.Data;
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
@Data
public class Business001 implements IBusinessAfter, ILogAfter {

    /**
     * 简单配置例子
     */
    private String version;

    @Value("${user.name}")
    private String name;

    public String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run(Request request, Result result, Object extendObj) {
        System.out.println("神奇的执行方法,version:" + version);
    }

    @Override
    public void writeLog(Request request, Result result, Object extendObj) {
        System.out.println("记录修改日志：" + readableValue(request, result));
    }
}
