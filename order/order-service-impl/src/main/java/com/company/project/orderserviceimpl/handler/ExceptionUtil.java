package com.company.project.orderserviceimpl.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;

public class ExceptionUtil {
    public static Result handleException(Request request, BlockException ex) {
        return Result.ok("限流。。。");
    }
}