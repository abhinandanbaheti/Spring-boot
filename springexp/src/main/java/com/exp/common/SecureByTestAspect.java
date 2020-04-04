package com.exp.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

@Aspect
@Component
public class SecureByTestAspect {


    //private SecureByTestResolver secureByTestResolver;
    private SecureByTestExtender secureByTestExtender;

    @Autowired
    public SecureByTestAspect(SecureByTestExtender secureByTestExtender){
        this.secureByTestExtender = secureByTestExtender;
    }

    @Before("@annotation(com.exp.common.SecureByTest)")
    public void accessCheck(final JoinPoint joinPoint) {
        Method targetMethod = ((MethodSignature) joinPoint.getSignature()).getMethod();
        SecureByTest annotation = targetMethod.getAnnotation(SecureByTest.class);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
        System.out.println(targetMethod.getName());
        System.out.println(joinPoint.getArgs());
        String resourceName = annotation.name();
        String resourceId = "";

        Map<String, String> methodRequestParams = (Map<String, String>) request
                .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        if (methodRequestParams.containsKey(resourceName)) {
            resourceId = methodRequestParams.get(resourceName);
        }

        if(secureByTestExtender.supports(annotation.resolver())){
            String resource = secureByTestExtender.resolveResource(resourceId);
            // Validaton if the resource returned from the resolver has to be validated against some request context attribute or something else
            if (!resource.equalsIgnoreCase(resourceId)){
                testThrowException();
            }
        }
    }

    public void testThrowException() {
        throw new RuntimeException("unauthorized");
    }
}
