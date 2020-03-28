package com.soft1851.spring.webAnnotation.dao;

import com.soft1851.spring.webAnnotation.entity.Topic;

import java.util.List;

/**
 * @author zhao
 * @className TopicDao
 * @Description TODO
 * @Date 2020/3/26
 * @Version 1.0
 **/
public interface TopicDao {
    /**
     * 查询所有
     * @return
     */
    List<Topic> selectAll();

    /**
     * 批量插入
     * @param topics
     * @return int[]
     */
    int[] batchInsert(List<Topic> topics);

    /**
     * 新增一个
     * @param topic
     * @return int
     */
    int insert(Topic topic);
}
