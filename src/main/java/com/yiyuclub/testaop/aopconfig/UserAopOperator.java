package com.yiyuclub.testaop.aopconfig;

import com.google.gson.Gson;
import org.apache.tomcat.util.json.JSONParser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAopOperator {

    @Pointcut("execution(public * com.yiyuclub.testaop.controller..*.*(..))")
    public void test(){
        System.out.println("aop切入点");
    }

    @Before("test()")
    public void doBefore(JoinPoint joinPoint)throws Exception{
        System.out.println(new Gson().toJson(joinPoint.getArgs()));
    }

    @After("test()")
    public void doAfter(JoinPoint joinPoint)throws Exception{
        System.out.println(new Gson().toJson(joinPoint.getArgs()));
    }
}
