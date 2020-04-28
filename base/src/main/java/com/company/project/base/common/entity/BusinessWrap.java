package com.company.project.base.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessWrap {
    private String clazz;
    private String action;

    BusinessWrap(String clazz) {
        this.clazz = clazz;
    }
}