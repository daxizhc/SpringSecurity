package com.imooc.security.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class TimeAspect {

    @Around("execution(* com.imooc.security.demo.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is " + arg);
        }

        long start = new Date().getTime();
        Object result = pjp.proceed();
        long end = new Date().getTime();
        System.out.println("time aspect 耗时：" + (end - start));

        System.out.println("time aspect end");
        return result;
    }

}
