package com.soft1851.spring.demo.controller;

import com.soft1851.spring.demo.common.Result;
import com.soft1851.spring.demo.domain.LoginDto;
import com.soft1851.spring.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhao
 * @className UserController
 * @Description TODO
 * @Date 2020/4/4
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping(value = "/login")
    Result signIn(LoginDto loginDto){
        return  userService.login(loginDto);
    }
}
