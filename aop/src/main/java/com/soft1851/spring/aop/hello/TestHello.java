package com.soft1851.spring.aop.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhao
 * @className TestHello
 * @Description TODO
 * @Date 2020/4/6
 * @Version 1.0
 **/
public class TestHello {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = (Hello) ac.getBean("hello");
        System.out.println(hello.sayHello());
    }
}
