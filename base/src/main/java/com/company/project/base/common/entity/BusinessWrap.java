package com.company.project.base.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessWrap {
    private Class clazz;
    private String action;

    BusinessWrap(Class clazz) {
        this.clazz = clazz;
    }
}