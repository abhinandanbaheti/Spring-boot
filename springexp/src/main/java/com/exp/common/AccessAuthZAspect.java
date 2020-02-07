package com.exp.common;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AccessAuthZAspect {

    @Before("@annotation(com.exp.common.AuthZAccess)")
    public void accessCheck(final JoinPoint joinPoint) {
        Method targetMethod = ((MethodSignature) joinPoint.getSignature()).getMethod();
        AuthZAccess annotation = targetMethod.getAnnotation(AuthZAccess.class);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();

        if (annotation.admin() && !isAdmin(request)) {
            throw new RuntimeException("Need admin access");
        }

        if (annotation.isLocal() && !request.getRemoteAddr().equals("127.0.0.1")) {
            throw new RuntimeException("Need local access");
        }
    }

    public boolean isAdmin(final HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        return authorization != null && authorization.replace("Bearer ", "").equalsIgnoreCase("admin");
    }
}