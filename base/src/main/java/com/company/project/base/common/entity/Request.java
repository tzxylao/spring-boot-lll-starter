package com.company.project.base.common.entity;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author: laoliangliang
 * @description: 通用请求类
 * @create: 2020/4/20 13:59
 **/
@Data
@NotNull
public class Request<T> extends AbstractBusiness{
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

}
