package com.soft1851.spring.web.dao.impl;

import com.soft1851.spring.web.dao.PostDao;
import com.soft1851.spring.web.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhao
 * @className PostDaoImpl
 * @Description TODO
 * @Date 2020/3/21
 * @Version 1.0
 **/
@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Post> selectAll() {
        String sql = "SELECT * FROM t_post";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Post.class));
    }
}
