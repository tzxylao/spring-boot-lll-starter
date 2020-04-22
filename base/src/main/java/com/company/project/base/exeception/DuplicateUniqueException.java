package com.company.project.base.exeception;

/**
 * @Author laoliangliang
 * @description
 * @Date 2019/11/27 14:33
 **/
public class DuplicateUniqueException extends RuntimeException {

    public DuplicateUniqueException(String message) {
        super(message);
    }

    public DuplicateUniqueException(String message, Throwable cause) {
        super(message, cause);
    }
}
