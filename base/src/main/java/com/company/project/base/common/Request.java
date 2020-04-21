package com.company.project.base.common;

import lombok.Data;

import java.util.Map;

/**
 * @author: laoliangliang
 * @description: 通用请求类
 * @create: 2020/4/20 13:59
 **/
@Data
public class Request<T> {
    /**
     * 请求体
     */
    private T body;

    /**
     * 请求码(预留可不填)
     */
    private Integer requestCode;

    /**
     * 额外请求参数，可另做处理
     */
    private Map<String,Object> extend;
}
