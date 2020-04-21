package com.company.project.base.exeception;

import com.company.project.base.common.Result;
import com.netflix.hystrix.exception.HystrixBadRequestException;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/21 15:49
 **/
public class ExceptionProcessor {
    public static Result getResult(String param) {
        throw new HystrixBadRequestException(param);
    }
}
