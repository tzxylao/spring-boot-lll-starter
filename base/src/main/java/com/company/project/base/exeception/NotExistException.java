package com.company.project.base.exeception;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/3/26 14:13
 **/
public class NotExistException extends RuntimeException {
    public NotExistException() {
        super();
    }

    public NotExistException(String message) {
        super(message);
    }

    public NotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotExistException(Throwable cause) {
        super(cause);
    }

    protected NotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
