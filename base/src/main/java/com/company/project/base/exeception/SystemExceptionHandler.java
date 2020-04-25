package com.company.project.base.exeception;

import cn.hutool.core.util.ObjectUtil;
import com.company.project.base.common.entity.Result;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import feign.FeignException;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.ClassUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.company.project.base.common.enums.BaseStatusEnum.*;

/**
 * @author laoliangliang
 * @date 2019/12/03 10:22
 */
@ControllerAdvice
@Slf4j
public class SystemExceptionHandler {

    @Autowired(required = false)
    private IExceptionFilter exceptionFilter;

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result methodArgumentNotValidExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder errMsg = new StringBuilder(bindingResult.getFieldErrors().size() * 16);
        errMsg.append("错误请求:");
        for (int i = 0; i < bindingResult.getFieldErrors().size(); i++) {
            if (i > 0) {
                errMsg.append(",");
            }
            FieldError error = bindingResult.getFieldErrors().get(i);
            errMsg.append(error.getField() + error.getDefaultMessage());
        }
        return Result.failure(FAILURE.code(), errMsg.toString());

    }

    @ExceptionHandler(value = {DuplicateUniqueException.class, DuplicateKeyException.class})
    @ResponseBody
    public Result duplicateUniqueExceptionExceptionHandler(HttpServletRequest request, Exception e) {
        return getExceptionResult(e, FAILURE_UNIQUE_CODE.code(), FAILURE_UNIQUE_CODE.msg(), false);
    }

    @ExceptionHandler(value = {DataNullException.class})
    @ResponseBody
    public Result dataExceptionHandler(HttpServletRequest request, DataNullException e) {
        String msg = e.getMessage();
        return getExceptionResult(e, FAILURE_DATA.code(), ObjectUtil.defaultIfNull(msg, FAILURE_DATA.msg()), false);
    }

    @ExceptionHandler(value = {ConditionException.class})
    @ResponseBody
    public Result dataExceptionHandler(HttpServletRequest request, ConditionException e) {
        String msg = e.getMessage();
        return getExceptionResult(e, FAILURE_CONDITION.code(), ObjectUtil.defaultIfNull(msg, FAILURE_CONDITION.msg()), false);
    }

    @ExceptionHandler(value = NotExistException.class)
    @ResponseBody
    public Result notExistExceptionHandler(HttpServletRequest request, NotExistException e) {
        String msg = e.getMessage();
        return getExceptionResult(e, FAILURE_NOT_EXIST.code(), ObjectUtil.defaultIfNull(msg, FAILURE_NOT_EXIST.msg()), false);
    }

    @ExceptionHandler(value = RetryableException.class)
    @ResponseBody
    public Result notExistExceptionHandler(HttpServletRequest request, RetryableException e) {
        String msg = e.getMessage();
        return getExceptionResult(e, TIME_OUT.code(), ObjectUtil.defaultIfNull(msg, TIME_OUT.msg()), false);
    }

    @ExceptionHandler(value = {FeignException.class, RuntimeException.class})
    @ResponseBody
    public Result FeignExceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        throw e;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result commonExceptionHandler(HttpServletRequest request, Exception e) {
        return getExceptionResult(e, FAILURE.code(), true);
    }

    @ExceptionHandler(value = HystrixRuntimeException.class)
    @ResponseBody
    public Result hystrixExceptionHandler(HttpServletRequest request, HystrixRuntimeException e) {
        Throwable fallbackException = e.getFallbackException();
        String msg = fallbackException.getCause().getMessage().split(":")[1];
        return getExceptionResult(e, FAILURE_HYSTRIX.code(), ObjectUtil.defaultIfNull(msg, FAILURE_DATA.msg()), true);
    }

    private Result getExceptionResult(Exception e, int statusCode, boolean ignoreAlert) {
        return getExceptionResult(e, statusCode, e.getMessage(), ignoreAlert);
    }

    private Result getExceptionResult(Exception e, int statusCode, String msg, boolean ignoreAlert) {
        e.printStackTrace();
        String exceptionName = ClassUtils.getShortName(e.getClass());
        StackTraceElement[] stackTrace = e.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.toString()).append("\n");
        }
        String message = e.getMessage();
        if (ignoreAlert && filter(e)) {
            log.error("ExceptionName ==> {}，message:{},detail:{}", exceptionName, message, sb.toString());
        }
        return Result.failure(statusCode, msg);
    }

    private boolean filter(Exception e) {
        if (exceptionFilter != null) {
            return exceptionFilter.filter(e);
        }
        return true;
    }
}
