package com.soft1851.spring.mybatis.dao;

import com.soft1851.spring.mybatis.entity.Music;

import java.util.List;

/**
 * @author zhao
 * @className MusicDao
 * @Description TODO
 * @Date 2020/4/3
 * @Version 1.0
 **/
public interface MusicDao {
    /**
     * 批量插入
     * @param travels
     * @return int[]
     */
    int[] batchInsert(List<Music> travels);
}
