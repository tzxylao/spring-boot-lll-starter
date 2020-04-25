package com.company.project.base.common.enums;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/21 15:49
 **/
public enum BaseStatusEnum {
    /**
     * 操作码和消息
     */
    SUCCESS(20000,"操作成功"),
    FAILURE(50000, "操作失败"),
    FAILURE_UNIQUE_CODE(50001, "唯一主键重复（或联合唯一键）"),
    FAILURE_DATA(50002, "数据异常"),
    FAILURE_CONDITION(50003, "条件异常"),
    FAILURE_NOT_EXIST(50004, "不存在异常"),
    FAILURE_HYSTRIX(50005, "熔断异常"),
    TIME_OUT(50006, "超时异常")
    ;

    private Integer code;
    private String msg;

    BaseStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return code;
    }

    public String msg() {
        return msg;
    }

}
