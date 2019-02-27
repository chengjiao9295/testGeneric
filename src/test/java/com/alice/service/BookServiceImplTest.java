package com.alice.service;

import com.alice.BaseTest;
import com.alice.bean.book;
import com.alice.controller.bookController;
import com.alice.dao.bookMapper;
import com.alice.genericTest.GenericTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

public class BookServiceImplTest extends BaseTest {
    @Autowired
    private bookService bookService;

    @Test
    public void testAppoint() throws Exception {
         //bookService.getBookInformation();
        ApplicationContext context = new ClassPathXmlApplicationContext( new String []{
                "application-spring.xml", "application-mybatis.xml"
        });

//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "context.xml");
       bookController a = (bookController) context.getBean("bookController");
       bookMapper b = (bookMapper) context.getBean("bookMapper");
       bookService c=(bookServiceImpl) context.getBean("bookServiceImpl");
       System.out.println(a);
//       /System.out.println(/b);

    }
}
