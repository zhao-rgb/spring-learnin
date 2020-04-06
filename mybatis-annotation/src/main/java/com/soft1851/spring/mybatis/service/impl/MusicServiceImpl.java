package com.soft1851.spring.mybatis.service.impl;

import com.soft1851.spring.mybatis.dao.MusicDao;
import com.soft1851.spring.mybatis.entity.Music;
import com.soft1851.spring.mybatis.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhao
 * @className MusicServiceImpl
 * @Description TODO
 * @Date 2020/4/3
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicDao musicDao;

    @Override
    public int[] bathInsert(List<Music> musics) {
        return musicDao.batchInsert(musics);
    }
}
