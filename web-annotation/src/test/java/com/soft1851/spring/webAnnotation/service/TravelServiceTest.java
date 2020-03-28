package com.soft1851.spring.webAnnotation.service;

import com.soft1851.spring.webAnnotation.config.SpringDataSourceConfig;
import com.soft1851.spring.webAnnotation.spider.XieChengSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class TravelServiceTest {

    @Autowired
    private TravelService travelService;

    @Test
    public void bathInsert() {
            int[] ints = travelService.bathInsert(XieChengSpider.getTravels());
            assertEquals(XieChengSpider.getTravels().size(),ints.length);
    }
}