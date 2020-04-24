package com.company.project.base.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;
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
    @Valid
    private T body;

    /**
     * 请求码(预留可不填)
     */
    private Integer requestCode;

    /**
     * 额外请求参数，可另做处理
     */
    private Map<String,Object> extend;

    /**
     * 执行业务类名
     */
    @JsonIgnore
    private List<BusinessWrap> businessClass;

    public static BusinessWrap wrap(Class clazz) {
        return new BusinessWrap(clazz);
    }

    public static BusinessWrap wrap(Class clazz,String action) {
        return new BusinessWrap(clazz, action);
    }
}
