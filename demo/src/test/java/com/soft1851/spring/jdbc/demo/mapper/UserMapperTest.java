package com.soft1851.spring.jdbc.demo.mapper;

import com.soft1851.spring.demo.domain.entity.User;
import com.soft1851.spring.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-mybatis.xml")
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void selectById() throws SQLException {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void updateCredits() {
        userMapper.updateCredits(10,1);
    }

    @Test
    public void insert() throws SQLException {
        User user = User.builder().userId(25).phoneNumber(18094278).build();
        userMapper.insert(user);
    }

    @Test
    public  void  selectUser()throws SQLException{
        User user =userMapper.selectUser("123456565");
        System.out.println(user);
    }
}