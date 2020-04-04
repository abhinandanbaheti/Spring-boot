package com.exp.common;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlerAspect {

    private static int exceptionCounter=0;

    //@AfterThrowing(pointcut = "execution(* com.exp.common.SecureByTestAspect.testThrowException(..))", throwing = "exception")
    @AfterThrowing(pointcut = "execution(* com.exp.persistence.TestPersistenceException.testThrowException(..))", throwing = "exception")
    public void handleExceptions(Exception exception) {
        if (exception instanceof RuntimeException) {
            exceptionCounter++;
            System.out.println("Exception Handled : " + exceptionCounter);
        }
    }
}