package com.soft1851.spring.jdbc.ioc.entity;

import com.soft1851.spring.ioc.config.StudentConfig;
import com.soft1851.spring.ioc.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StudentConfig.class})
public class StudentTest {
    @Autowired
    private Student student;
    @Test
    public void print(){
        System.out.println(student);
    }
}