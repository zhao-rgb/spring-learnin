package com.soft1851.spring.demo.service.impl;

import com.soft1851.spring.demo.common.Result;
import com.soft1851.spring.demo.common.ResultCode;
import com.soft1851.spring.demo.domain.LoginDto;
import com.soft1851.spring.demo.domain.UserDto;
import com.soft1851.spring.demo.domain.entity.User;
import com.soft1851.spring.demo.mapper.UserMapper;
import com.soft1851.spring.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author zhao
 * @className UserServiceImpl
 * @Description TODO
 * @Date 2020/4/3
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Result login(LoginDto loginDto) {
        User admin = null;
        try {
            admin = userMapper.selectUser(loginDto.getPhoneNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (admin != null){
            if(DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes()).equals(admin.getPassword())){
                System.out.println(admin);
                return Result.success(admin);
            }else {
                return Result.failure(ResultCode.USER_PASSWORD_ERROR);
            }
        } else {
            return Result.failure(ResultCode.USER_ACCOUNT_NOT_EXIST);
        }
    }


    @Override
    public int batchDelete(UserDto userDto) {
        int n = userMapper.batchDelete(userDto.getUserId(), userDto.getMusicList());
        return n;
    }


}
