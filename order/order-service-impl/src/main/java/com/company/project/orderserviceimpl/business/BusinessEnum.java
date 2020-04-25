package com.company.project.orderserviceimpl.business;


import com.company.project.orderserviceimpl.business.clazz.Business001;

/**
 * @author: laoliangliang
 * @description: 通用业务编码，模块专属，每个模块可以有自己的通用业务编码，该编码的意义在于将多接口共同修改的部分业务逻辑抽象出来
 * @create: 2020/4/20 11:43
 **/
public enum BusinessEnum {
    /**
     * 通用业务编码
     */
    A001(Business001.class,"业务描述");
    private Class clazz;
    private String desc;

    BusinessEnum(Class clazz,String desc) {
        this.clazz = clazz;
        this.desc = desc;
    }

    public Class getClazz() {
        return clazz;
    }

    public String getDesc() {
        return desc;
    }
}
