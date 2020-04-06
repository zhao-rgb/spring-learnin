package com.soft1851.spring.jdbc.webAnnotation.service;

import com.soft1851.spring.webAnnotation.service.TopicService;
import com.soft1851.spring.webAnnotation.spider.JueJinSpider;
import com.soft1851.spring.webAnnotation.config.SpringDataSourceConfig;
import com.soft1851.spring.webAnnotation.entity.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class TopicServiceTest {

    @Autowired
    private TopicService topicService;

    @Test
    public void queryAll() {
        List<Topic> topics = topicService.queryAll();
        assertEquals(45,topics.size());
    }

    @Test
    public void addTopic() {
    }

    @Test
    public void bathInsert() {
        int[] ints = topicService.bathInsert(JueJinSpider.getTopics());
        assertEquals(JueJinSpider.getTopics().size(),ints.length);
    }
}