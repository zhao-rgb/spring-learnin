package com.soft1851.spring.webAnnotation.service.impl;

import com.soft1851.spring.webAnnotation.dao.TopicDao;
import com.soft1851.spring.webAnnotation.entity.Topic;
import com.soft1851.spring.webAnnotation.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhao
 * @className TopicServiceImpl
 * @Description @Transactional(rollbackFor = Exception.class),如果类加了这个注解，那么这个类里面的方法抛出异常，就会回滚，数据库里面的数据也会回滚
 * @Date 2020/3/27
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Override
    public List<Topic> queryAll() {
        return topicDao.selectAll();
    }

    @Override
    public void addTopic(Topic topic) {
        topicDao.insert(topic);
//        try {
//            int a = 1 / 0;
//        } catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException();
//        }

    }

    @Override
    public int[] bathInsert(List<Topic> topics) {
        return topicDao.batchInsert(topics);
    }
}
