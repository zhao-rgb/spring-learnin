package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Forum;

import java.util.List;

/**
 * @author zhao
 * @className ForumService
 * @Description TODO
 * @Date 2020/3/20 13:57
 * @Version 1.0
 **/
public interface ForumService {

    /**
     * 查询所有论坛信息
     * @return  List<Forum>
     */
    List<Forum> selectAll();

    /**
     * 根据id查询Forum
     * @param forumId
     * @return Forum
     */
    Forum get(int forumId);

}
