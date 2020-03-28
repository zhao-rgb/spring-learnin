package com.soft1851.spring.webAnnotation.service;

import com.soft1851.spring.webAnnotation.entity.Travel;

import java.util.List;

/**
 * @author zhao
 * @className TravelService
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
public interface TravelService {

    /**
     * 查询所有
     * @return List<Topic>
     */
    List<Travel> queryAll();

    /**
     * 批量插入
     * @param travels
     * @return int[]
     */
    int[] bathInsert(List<Travel> travels);
}
