package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.PostDao;
import com.soft1851.spring.web.entity.Post;
import com.soft1851.spring.web.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhao
 * @className PostServiceImpl
 * @Description TODO
 * @Date 2020/3/21
 * @Version 1.0
 **/
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> selectAll() {
        return postDao.selectAll();
    }
}
