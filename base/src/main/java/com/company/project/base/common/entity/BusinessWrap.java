package com.company.project.base.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class BusinessWrap {
    /**
     * 用作业务类
     */
    private Class bussinessClazz;

    /**
     * 扩展对象，填写自定义对象
     */
    private Object extendObj;

    /**
     * 执行业务动作
     */
    private String action;

    BusinessWrap(Class bussinessClazz) {
        this.bussinessClazz = bussinessClazz;
    }

    public BusinessWrap(Class bussinessClazz, Object extendObj) {
        this.bussinessClazz = bussinessClazz;
        this.extendObj = extendObj;
    }

}