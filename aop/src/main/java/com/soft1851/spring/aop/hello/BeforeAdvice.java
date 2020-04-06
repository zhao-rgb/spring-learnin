package com.soft1851.spring.aop.hello;

/**
 * @author zhao
 * @className BeforeAdvice
 * @Description 前置增强类
 * @Date 2020/4/6
 * @Version 1.0
 **/
public class BeforeAdvice {
    /**
     * 前置增强需要执行的方法
     */
    public void beforeMethod(){
        System.out.println("this is a before method...");
    }
}

