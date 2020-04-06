package com.soft1851.spring.demo.mapper;

import com.soft1851.spring.demo.domain.LoginDto;
import com.soft1851.spring.demo.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhao
 * @className UserMapper
 * @Description TODO
 * @Date 2020/4/3
 * @Version 1.0
 **/
public interface UserMapper {
    /**
     * 根据id查找用户信息
     * @param userId
     * @return
     */

    User selectById(int userId)throws SQLException;

    /**
     * 注册用户 , 动态sql判断非空
     *
     * @return
     */

    int insert(User user)throws  SQLException;

    /**
     * 根据邮箱或者手机号查找用户
     * @param account
     * @return
     */
    User selectUser(String account)throws SQLException;

    /**
     * 登陆后更新最后登陆时间，用于判断该用户一天登陆几次
     *
     * @param user
     * @return
     */

    int updateLoginLastLoginTime(User user);

    /**
     * 更新积分
     * @param credit
     * @param userId
     * @return
     */

    int updateCredits(@Param("credit")int credit, @Param("userId")int userId);

    /**
     * 用户批量取消收藏
     * @param userId
     * @param list
     * @return
     */

    int batchDelete(@Param("userId") String userId, @Param("idList") List<String> list);

    /**
     * 登录
     * @param loginDto
     * @return
     * @throws SQLException
     */
    @Select("SELECT phone_number,password FROM t_user WHERE phone_number=#{phoneNumber} and password=#{password}")
    User login(LoginDto loginDto) throws SQLException;
}

