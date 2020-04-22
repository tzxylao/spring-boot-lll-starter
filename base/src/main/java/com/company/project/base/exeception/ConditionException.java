package com.company.project.base.exeception;

/**
 * @Author laoliangliang
 * @description
 * @Date 2019/11/27 14:33
 **/
public class ConditionException extends RuntimeException {

    public ConditionException(String message) {
        super(message);
    }

    public ConditionException(String message, Throwable cause) {
        super(message, cause);
    }
}
