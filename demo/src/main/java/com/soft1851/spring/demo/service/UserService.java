package com.soft1851.spring.demo.service;

import com.soft1851.spring.demo.common.Result;
import com.soft1851.spring.demo.domain.LoginDto;
import com.soft1851.spring.demo.domain.UserDto;

/**
 * @author zhao
 * @className klk
 * @Description TODO
 * @Date 2020/4/3
 * @Version 1.0
 **/
public interface UserService {
    /**
     * 登录接口
     * @param loginDto
     * @return
     */
    Result login(LoginDto loginDto);

    //批量取消收藏
    int batchDelete(UserDto userDto);
}
