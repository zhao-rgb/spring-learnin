package com.soft1851.spring.jdbc.mybatis.service;

import com.soft1851.spring.mybatis.config.MapperConfig;
import com.soft1851.spring.mybatis.service.MusicService;
import com.soft1851.spring.mybatis.splider.lp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MapperConfig.class})
public class MusicServiceTest {
    @Resource
    private MusicService musicService;

    @Test
    public void bathInsert() {
        int[] ints = musicService.bathInsert(lp.getMusics());
        assertEquals(lp.getMusics().size(),ints.length);
    }
}