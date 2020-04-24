package com.company.project.producerserviceimpl.business;

import com.company.project.producerserviceimpl.business.clazz.Business001;

/**
 * @author: laoliangliang
 * @description: 通用业务编码，模块专属，每个模块可以有自己的通用业务编码，该编码的意义在于将多接口共同修改的部分业务逻辑抽象出来
 * @create: 2020/4/20 11:43
 **/
public enum BusinessEnum {
    /**
     * 通用业务编码
     */
    A001(Business001.class);
    private Class clazz;

    BusinessEnum(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }
}
