package com.company.project.base.common.entity;

import com.company.project.base.common.BaseStatusCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: laoliangliang
 * @description: 通用返回结果类
 * @create: 2020/4/20 11:06
 **/
@Data
public class Result<T> {
    private T data;
    private Integer code;
    private Boolean success;
    /**
     * 执行业务类名
     */
    @JsonIgnore
    private List<String> businessClass;

    public Result<T> addBusinessClass(List<String> businessClass) {
        List<String> businessClassList = this.getBusinessClass();
        if (businessClassList == null) {
            businessClassList = new ArrayList<>();
            this.setBusinessClass(businessClassList);
        }
        this.getBusinessClass().addAll(businessClass);
        return this;
    }

    public Result<T> addBusinessClass(String businessClass) {
        List<String> businessClassList = this.getBusinessClass();
        if (businessClassList == null) {
            businessClassList = new ArrayList<>();
            this.setBusinessClass(businessClassList);
        }
        this.getBusinessClass().add(businessClass);
        return this;
    }

    public static <T> Result<T> ok() {
        return ok(null);
    }

    public static <T> Result<T> ok(T data) {
        return ok(data, null);
    }

    public static <T> Result<T> ok(Integer code, T data) {
        return ok(code, data, null);
    }

    public static <T> Result<T> ok(T data, List<String> businessClass) {
        return ok(BaseStatusCode.SUCCESS.code(), data, businessClass);
    }

    public static <T> Result<T> ok(Integer code, T data, List<String> businessClass) {
        return get(true, code, data, businessClass);
    }

    public static <T> Result<T> get(Boolean success, Integer code, T data, List<String> businessClass) {
        Result<T> result = new Result<>();
        result.setSuccess(success);
        result.setCode(code);
        result.setData(data);
        result.setBusinessClass(businessClass);
        return result;
    }

    public static <T> Result<T> failure() {
        return failure(null);
    }

    public static <T> Result<T> failure(T data) {
        return failure(data, null);
    }

    public static <T> Result<T> failure(Integer code, T data) {
        return failure(code, data, null);
    }

    public static <T> Result<T> failure(T data, List<String> businessClass) {
        return failure(BaseStatusCode.FAILURE.code(), data, businessClass);
    }

    public static <T> Result<T> failure(Integer code, T data, List<String> businessClass) {
        return get(false, code, data, businessClass);
    }

}
