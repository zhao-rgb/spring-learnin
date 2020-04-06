package com.soft1851.spring.mybatis.dao.impl;

import com.soft1851.spring.mybatis.dao.MusicDao;
import com.soft1851.spring.mybatis.entity.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhao
 * @className MusicDaoImpl
 * @Description TODO
 * @Date 2020/4/3
 * @Version 1.0
 **/
@Repository
public class MusicDaoImpl implements MusicDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int[] batchInsert(List<Music> travels) {
        final List<Music> musicList = travels;
        String sql = "INSERT INTO sys_music (id,url,music_name)" +
                "VALUES(?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Music music = musicList.get(i);
                preparedStatement.setInt(1,music.getId());
                preparedStatement.setString(2,music.getUrl());
                preparedStatement.setString(3,music.getMusicName());

            }
            @Override
            public int getBatchSize() {
                return musicList.size();
            }
        });
    }
}
