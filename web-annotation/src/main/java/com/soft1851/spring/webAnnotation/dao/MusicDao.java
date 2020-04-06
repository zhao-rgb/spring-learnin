package com.soft1851.spring.webAnnotation.dao;


import com.soft1851.spring.webAnnotation.entity.Music;

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
     * @param musics
     * @return int[]
     */
    int[] batchInsert(List<Music> musics);
}
