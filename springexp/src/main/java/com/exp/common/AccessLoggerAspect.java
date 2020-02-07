package com.exp.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccessLoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessLoggerAspect.class);

    @Around("@annotation(com.exp.common.LogAccess)")
    public Object logDataAccess(ProceedingJoinPoint joinPoint) throws Throwable {

        LOGGER.info("Before invoking the target");

        Object invocationResult = joinPoint.proceed();

        LOGGER.info("After invoking the target");

        return invocationResult;
    }
}