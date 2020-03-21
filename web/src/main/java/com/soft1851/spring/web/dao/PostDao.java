package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Post;

import java.util.List;

/**
 * @author zhao
 * @className PostDao
 * @Description TODO
 * @Date 2020/3/21
 * @Version 1.0
 **/
public interface PostDao {
    /**
     * 查询所有论坛信息
     * @return  List<Forum>
     */
    List<Post> selectAll();
}
