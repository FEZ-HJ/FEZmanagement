package com.fez.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by H.J
 * 2018/10/5
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.fez.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("time aspect start");

        Object[] args = pjp.getArgs();
        for(Object arg : args){
            System.out.println("arg is : " + arg);
        }
        Long start = new Date().getTime();

        Object o = pjp.proceed();

        System.out.println("TimeAspect :" + (new Date().getTime() -start));

        System.out.println("time aspect end");

        return o;
    }

}
