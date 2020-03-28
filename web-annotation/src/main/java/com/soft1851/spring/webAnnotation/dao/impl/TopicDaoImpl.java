package com.soft1851.spring.webAnnotation.dao.impl;

import com.soft1851.spring.webAnnotation.dao.TopicDao;
import com.soft1851.spring.webAnnotation.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhao
 * @className TopicDaoImpl
 * @Description TODO
 * @Date 2020/3/26
 * @Version 1.0
 **/
@Repository
public class TopicDaoImpl implements TopicDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Topic> selectAll() {
        String sql = "SELECT * FROM t_topic";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Topic.class));
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        final List<Topic> topicList = topics;
        String sql = "INSERT INTO t_topic (id,topic_name,topic_icon,description,followers_count,msg_count,followed)" +
                "VALUES(?,?,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Topic topic = topicList.get(i);
                preparedStatement.setString(1,topic.getId());
                preparedStatement.setString(2,topic.getTopicName());
                preparedStatement.setString(3,topic.getTopicIcon());
                preparedStatement.setString(4,topic.getDescription());
                preparedStatement.setInt(5,topic.getMsgCount());
                preparedStatement.setInt(6,topic.getFollowersCount());
                preparedStatement.setBoolean(7,topic.getFollowed());
            }

            @Override
            public int getBatchSize() {
                return topicList.size();
            }
        });
    }

    @Override
    public int insert(Topic topic) {
        String sql = "INSERT INTO t_topic (id,topic_name,topic_icon,description,followers_count,msg_count,followed)" +
                "VALUES(?,?,?,?,?,?,?)";
        Object[] params = {topic.getId(),topic.getTopicName(),topic.getTopicIcon(),topic.getDescription(),
                 topic.getMsgCount(),topic.getFollowersCount(),topic.getFollowed()};
        return jdbcTemplate.update(sql,params);
    }
}
