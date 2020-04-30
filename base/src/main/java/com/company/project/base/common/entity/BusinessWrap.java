package com.company.project.base.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class BusinessWrap {
    private Class clazz;
    private Object extendObj;
    private String action;

    BusinessWrap(Class clazz) {
        this.clazz = clazz;
    }

    public BusinessWrap(Class clazz, Object extendObj) {
        this.clazz = clazz;
        this.extendObj = extendObj;
    }
}