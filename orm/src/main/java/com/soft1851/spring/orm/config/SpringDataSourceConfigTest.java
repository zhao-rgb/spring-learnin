package com.soft1851.spring.orm.config;


import com.soft1851.spring.orm.dao.ForumDao;
import com.soft1851.spring.orm.entity.Forum;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author zhao
 * @className SpringDataSourceConfigTest
 * @Description TODO
 * @Date 2020/3/19
 * @Version 1.0
 **/
public class SpringDataSourceConfigTest {
    public static void main(String[] args) {
        //生成基于注解配置的应用上下文对象
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDataSourceConfig.class);
        //手动开启扫包
        ctx.scan("com.soft1851.spring.ioc.config");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);

        ForumDao forumDao = (ForumDao) ctx.getBean("forumDao");
        List<Forum> forums = forumDao.selectAll();
        System.out.println(forums);
    }
}
