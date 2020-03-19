package com.soft1851.spring.ioc.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName StudentTest
 * @Description TODO
 * @Author
 * @Date 2020/3/17
 **/
public class StudentTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }
}