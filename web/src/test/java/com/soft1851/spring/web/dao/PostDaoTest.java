package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.dao.PostDao;
import com.soft1851.spring.web.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PostDaoTest {

    @Autowired
    private PostDao postDao;

    @Test
    public void selectAll() {
        List<Post> posts = postDao.selectAll();
        System.out.println(posts);
    }
}