package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Post;

import java.util.List;

/**
 * @author zhao
 * @className PostService
 * @Description TODO
 * @Date 2020/3/21
 * @Version 1.0
 **/
public interface PostService {
    List<Post> selectAll();
}
