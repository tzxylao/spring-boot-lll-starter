package com.company.project.base.exeception;

/**
 * @Author laoliangliang
 * @description
 * @Date 2019/11/27 14:33
 **/
public class DataException extends RuntimeException {

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }
}
