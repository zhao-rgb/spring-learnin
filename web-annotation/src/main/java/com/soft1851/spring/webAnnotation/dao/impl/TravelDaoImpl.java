package com.soft1851.spring.webAnnotation.dao.impl;

import com.soft1851.spring.webAnnotation.dao.TravelDao;
import com.soft1851.spring.webAnnotation.entity.Travel;
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
 * @className TravelDaoImpl
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
@Repository
public class TravelDaoImpl implements TravelDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Travel> selectAll() {
        String sql = "SELECT * FROM t_travel";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Travel.class));
    }

    @Override
    public int[] batchInsert(List<Travel> travels) {
        final List<Travel> travelList = travels;
        String sql = "INSERT INTO t_travel (city_image,city_name,title,num_view,want,num_reply,author_img,author_name,time)" +
                "VALUES(?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Travel travel = travelList.get(i);
                preparedStatement.setString(1,travel.getCityImage());
                preparedStatement.setString(2,travel.getCityName());
                preparedStatement.setString(3,travel.getTitle());
                preparedStatement.setInt(4,travel.getNumView());
                preparedStatement.setInt(5,travel.getWant());
                preparedStatement.setInt(6,travel.getNumReply());
                preparedStatement.setString(7,travel.getAuthorImg());
                preparedStatement.setString(8,travel.getAuthorName());
                preparedStatement.setString(9,travel.getTime());
            }

            @Override
            public int getBatchSize() {
                return travelList.size();
            }
        });
    }
}
