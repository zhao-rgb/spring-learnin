package com.soft1851.spring.jdbc.interceptor;

import org.aspectj.lang.annotation.*;

/**
 * @author zhao
 * @className MyAdvice
 * @Description TODO
 * @Date 2020/4/6
 * @Version 1.0
 **/
@Aspect
public class MyAdvice {
    /**
     * 定义切点
     */
    @Pointcut("execution(* com.soft1851.spring.jdbc..*.insert*(..))")
    public void pointCut(){
    }

    @Before("MyAdvice.pointCut()")
    public void beforeMethod(){
        System.out.println("等待数据插入。。。");
    }

    @AfterReturning("execution(* com.soft1851.spring.jdbc..*.*(..))")
    public void afterReturning(){
        System.out.println("关闭数据库。。。");
    }

    @AfterThrowing("execution(* com.soft1851.spring.jdbc..*.*(..))")
    public void afterException(){
        System.out.println("出现异常。。。");
    }

}
