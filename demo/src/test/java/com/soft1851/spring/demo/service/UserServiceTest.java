package com.soft1851.spring.demo.service;

import com.soft1851.spring.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-mybatis.xml")
public class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void login() {
    }
}