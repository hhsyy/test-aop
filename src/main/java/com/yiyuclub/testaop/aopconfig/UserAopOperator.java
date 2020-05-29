package com.yiyuclub.testaop.aopconfig;

import com.google.gson.Gson;
import org.apache.tomcat.util.json.JSONParser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
        System.out.println("切入点执行前执行");
        System.out.println(new Gson().toJson(joinPoint.getArgs()));
    }

    @Around("test()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("切入点执行前执行");
        joinPoint.proceed();//区分前后
        System.out.println("切入点执行后执行");
    }


    @After("test()")
    public void doAfter(JoinPoint joinPoint)throws Exception{
        System.out.println("切入点执行后执行");
        System.out.println(new Gson().toJson(joinPoint.getArgs()));
    }

    @AfterReturning("test()")
    public void afterReturning(JoinPoint point) {
        System.out.println("切入点执行返回结果后执行");
    }

    @AfterThrowing(value = "test()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("切入点执行异常后执行");
        System.out.println("ex = " + ex.getMessage());
    }


}
