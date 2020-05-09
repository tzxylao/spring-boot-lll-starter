package com.company.project.base.common.entity;

import com.company.project.base.common.enums.BaseStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: laoliangliang
 * @description: 通用返回结果类
 * @create: 2020/4/20 11:06
 **/
@Data
@Accessors(chain = true)
public class Result<T> extends AbstractBusiness {
    private T data;
    private Integer status;
    private Boolean success;
    private String message;
    /**
     * 原值，目前只用于日志获取原先值
     */
    @JsonIgnore
    private Object source;

    public Result<T> addBusinessClass(List<BusinessWrap> businessClass) {
        List<BusinessWrap> businessClassList = this.getBusinessClass();
        if (businessClassList == null) {
            businessClassList = new ArrayList<>();
            this.setBusinessClass(businessClassList);
        }
        this.getBusinessClass().addAll(businessClass);
        return this;
    }

    public Result<T> addBusinessClass(BusinessWrap businessClass) {
        List<BusinessWrap> businessClassList = this.getBusinessClass();
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
        return ok(data, null, null, null);
    }


    public static <T> Result<T> ok(T data, String message) {
        return ok(data, message, null);
    }

    public static <T> Result<T> ok(T data, Integer status) {
        return ok(data, status, null, null);
    }

    public static <T> Result<T> ok(T data, Integer status, String message) {
        return ok(data, status, message);
    }

    public static <T> Result<T> ok(T data, List<BusinessWrap> businessClass) {
        return ok(data, BaseStatusEnum.SUCCESS.code(), businessClass);
    }

    public static <T> Result<T> ok(T data, String message, List<BusinessWrap> businessClass) {
        return ok(data, BaseStatusEnum.SUCCESS.code(), message, businessClass);
    }

    public static <T> Result<T> ok(T data, Integer status, List<BusinessWrap> businessClass) {
        return ok(data, status, null, businessClass);
    }

    public static <T> Result<T> ok(T data, Integer status, String message, List<BusinessWrap> businessClass) {
        return get(true, status, data, message, businessClass);
    }

    public static <T> Result<T> get(Boolean success, Integer status, T data, String message, List<BusinessWrap> businessClass) {
        Result<T> result = new Result<>();
        result.setSuccess(success);
        result.setStatus(status);
        result.setData(data);
        result.setBusinessClass(businessClass);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> failure() {
        return failure(null);
    }

    public static <T> Result<T> failure(T data) {
        return failure(data, null, null);
    }

    public static <T> Result<T> failure(T data, String message) {
        return failure(data, message, null);
    }

    public static <T> Result<T> failure(T data, Integer status) {
        return failure(status, data, null, null);
    }

    public static <T> Result<T> failure(Integer status, T data, String message) {
        return failure(status, data, message, null);
    }

    public static <T> Result<T> failure(T data, List<BusinessWrap> businessClass) {
        return failure(BaseStatusEnum.FAILURE.code(), data, businessClass);
    }

    public static <T> Result<T> failure(T data, String message, List<BusinessWrap> businessClass) {
        return failure(BaseStatusEnum.FAILURE.code(), data, message, businessClass);
    }

    public static <T> Result<T> failure(Integer status, T data, List<BusinessWrap> businessClass) {
        return get(false, status, data, null, businessClass);
    }


    public static <T> Result<T> failure(Integer status, T data, String message, List<BusinessWrap> businessClass) {
        return get(false, status, data, message, businessClass);
    }
}
