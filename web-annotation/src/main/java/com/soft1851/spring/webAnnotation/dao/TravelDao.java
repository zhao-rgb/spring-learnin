package com.soft1851.spring.webAnnotation.dao;

import com.soft1851.spring.webAnnotation.entity.Travel;

import java.util.List;

/**
 * @author zhao
 * @className TravelDao
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
public interface TravelDao {

    /**
     * 查询所有
     * @return
     */
    List<Travel> selectAll();

    /**
     * 批量插入
     * @param travels
     * @return int[]
     */
    int[] batchInsert(List<Travel> travels);
}
