package com.soft1851.spring.aop.hello;

/**
 * @author zhao
 * @className HelloImpl
 * @Description TODO
 * @Date 2020/4/6
 * @Version 1.0
 **/
public class HelloImpl implements Hello{

    @Override
    public String sayHello() {
        return "hello";
    }
}
