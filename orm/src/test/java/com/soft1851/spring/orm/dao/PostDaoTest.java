package com.soft1851.spring.orm.dao;

import com.soft1851.spring.orm.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PostDaoTest {
    @Autowired
    private PostDao postDao;

    @Test
    public void insert() throws IOException {
        byte bbyte[]=null;
        File file = new File("D:\\图片\\1.png");
        FileInputStream inputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int len = 0;
        byte[] tem= new byte[1024];
        while ((len=inputStream.read(tem))!=-1){
            outputStream.write(tem,0,len);
        }
        inputStream.close();
        outputStream.flush();
        outputStream.close();
        bbyte= outputStream.toByteArray();
        Timestamp timestamp  =  Timestamp.valueOf(LocalDateTime.now());
        Post post = Post.builder().forumId(5).title("打球").content("哦搜索框哦").thumbnail(bbyte).postTime(timestamp).build();
        int n = postDao.insert(post);
        assertEquals(1,n);
    }

    @Test
    public void batchInsert() {
        Timestamp timestamp  =  Timestamp.valueOf(LocalDateTime.now());
        Post[] posts = {Post.builder().forumId(2).title("啦啦").content("哦搜索框哦").postTime(timestamp).build(),
                Post.builder().forumId(3).title("hh").content("打打球").postTime(timestamp).build(),
                Post.builder().forumId(4).title("跑步").content("运动").postTime(timestamp).build()
        };
        List<Post> postList = Arrays.asList(posts);
        int[] rows = postDao.batchInsert(postList);
        assertEquals(3,rows.length);
    }

    @Test
    public void batchdelete() {
        Post[] posts={Post.builder().postId(10).build(),Post.builder().postId(11).build()};
        List<Post> postList= Arrays.asList(posts);
        int[] rows =postDao.batchDelete(postList);
        assertEquals(2,rows.length);
    }

    @Test
    public void delete() {
        int n = postDao.delete(4);
        assertEquals(1,n);
    }

    @Test
    public void get() {
        Post post = postDao.get(1);
        assertNotNull(post);
    }

    @Test
    public void selectByKey() {
        List<Post> post = postDao.selectByKey("h");
        System.out.println(post);
    }
    @Test
    public void count() {
        int n = postDao.count();
        System.out.println(n);
    }
}