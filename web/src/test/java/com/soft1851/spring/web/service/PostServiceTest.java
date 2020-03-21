package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    public void selectAll() {
        List<Post> posts = postService.selectAll();
        System.out.println(posts);
    }
}