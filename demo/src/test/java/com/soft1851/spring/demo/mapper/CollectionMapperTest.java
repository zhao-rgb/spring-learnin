package com.soft1851.spring.demo.mapper;

import com.soft1851.spring.demo.domain.entity.Collectio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-mybatis.xml")
public class CollectionMapperTest {
    @Resource
    private CollectionMapper collectionMapper;

    @Test
    public void insert() {
        Collectio collection = Collectio.builder().userId("9").musicId("10").build();
        System.out.println(collectionMapper.insert(collection));
    }

    @Test
    public void selectById() {

        System.out.println(collectionMapper.selectById(Collectio.builder().userId("1").build()));

//        collectionMapper.selectById(Collectio.builder().musicId("1").build()).forEach(System.out::println);

//        userMapper.selectById(Collection.builder().musicId("1").userId("1").build()).forEach(System.out::println);
    }
}