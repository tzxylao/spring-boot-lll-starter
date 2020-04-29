package com.company.project.base.aop;

import com.alibaba.fastjson.JSON;
import com.company.project.base.business.IBusinessProcessor;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: laoliangliang
 * @description: 作为服务层业务统一调度的切面方法
 * @create: 2020/4/24 16:55
 **/
@Slf4j
@Component
@Aspect
@Order(1)
public class BusinessAround {

    @Autowired(required = false)
    private IBusinessProcessor businessProcessor;

    @Pointcut(value = "execution(com.company.project.base.common.entity.Result com.company.project.*.service.*.*(com.company.project.base.common.entity.Request))")
    private void pointcut() {
    }

    @Around("pointcut()")
    public Object handle(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("==========请求开始【" + Thread.currentThread().getId() + "】【" + joinPoint.getSignature().getName() + "】=============");
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String uri = request.getRequestURI().replace(request.getContextPath(), "");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 打印入参
        String inPutParam = preHandle(joinPoint);
        log.info("input:{}", inPutParam);
        Object result = joinPoint.proceed();
        String outPutParam = postHandle(joinPoint, result);
        stopWatch.stop();
        if (outPutParam != null && outPutParam.length() < 5000) {
            log.info("耗时：{}毫秒，uri:{},output:{}", stopWatch.getTotalTimeMillis(), uri, outPutParam);
        } else {
            log.info("耗时：{}毫秒，uri:{}", stopWatch.getTotalTimeMillis(), uri);
        }
        log.info("==========请求结束【" + Thread.currentThread().getId() + "】【" + joinPoint.getSignature().getName() + "】=============");
        return result;
    }

    private String postHandle(ProceedingJoinPoint joinPoint, Object result) {
        if (result instanceof Result) {
            if (businessProcessor != null) {
                Object[] args = joinPoint.getArgs();
                Request request = null;
                if (args.length > 0) {
                    Object arg = args[0];
                    if (arg instanceof Request) {
                        request = (Request) arg;
                    }
                }
                businessProcessor.after(request, (Result) result);
            }
            return JSON.toJSONString(result);
        }
        return null;
    }

    private String preHandle(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            Object arg = args[0];
            if (arg instanceof Request) {
                if (businessProcessor != null) {
                    businessProcessor.before((Request) arg);
                }
            }
        }
        List<Object> collect = Arrays.stream(joinPoint.getArgs())
                .filter(s -> !(s instanceof MultipartFile) && !(s instanceof HttpServletRequest) && !(s instanceof HttpServletResponse))
                .collect(Collectors.toList());
        return JSON.toJSONString(collect);
    }
}
