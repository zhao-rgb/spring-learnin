package com.soft1851.spring.jdbc.webAnnotation.dao;

import com.soft1851.spring.webAnnotation.config.SpringDataSourceConfig;
import com.soft1851.spring.webAnnotation.dao.TopicDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class TopicDaoTest {

    @Autowired
    private TopicDao topicDao;
    @Test
    public void selectAll() {
        System.out.println(topicDao.selectAll());
    }
}