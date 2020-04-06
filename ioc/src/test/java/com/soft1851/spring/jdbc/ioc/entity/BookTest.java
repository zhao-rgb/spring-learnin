package com.soft1851.spring.jdbc.ioc.entity;

import com.soft1851.spring.ioc.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class BookTest {

    @Autowired
    private Book book;

    @Test
    public void testToString() {
        book.setName("java");
        book.setPrice(88.8);
        System.out.println(book);
    }
}