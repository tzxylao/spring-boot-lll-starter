package com.company.project.base.exeception;

/**
 * @Author laoliangliang
 * @description
 * @Date 2019/11/27 14:33
 **/
public class DataNullException extends RuntimeException {

    public DataNullException(String message) {
        super(message);
    }

    public DataNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
