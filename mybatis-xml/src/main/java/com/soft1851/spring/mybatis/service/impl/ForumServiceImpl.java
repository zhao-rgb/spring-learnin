package com.soft1851.spring.mybatis.service.impl;

import com.soft1851.spring.mybatis.entity.Forum;
import com.soft1851.spring.mybatis.mapper.ForumMapper;
import com.soft1851.spring.mybatis.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhao
 * @className ForumServiceImpl
 * @Description TODO
 * @Date 2020/3/30
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumMapper forumMapper;

    @Override
    public void insert(Forum forum) {
        forumMapper.insert(forum);
    }

    @Override
    public void delete(int id) {
        forumMapper.delete(id);
    }

    @Override
    public void update(Forum forum) {
        forumMapper.update(forum);
    }

    @Override
    public List<Forum> selectAll() {
        return forumMapper.selectAll();
    }

    @Override
    public Forum selectForumById(int id) {
        return forumMapper.selectForumById(id);
    }
}
