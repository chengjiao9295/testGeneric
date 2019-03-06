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


//使用junit的@BeforeClass注解，表示在所以测试方法之前执行，且只执行一次。
//org.junit包下的@Before和@After分别表示在测试方法之前和之后执行的方法，对于每个测试方法都将执行一次；
public class BookServiceImplTest extends BaseTest {
    @Autowired
    private bookService bookService;

    @Test
    public void testAppoint() throws Exception {
         //bookService.getBookInformation();
        ApplicationContext context = new ClassPathXmlApplicationContext( new String []{
                "application-spring.xml", "application-mybatis.xml"
        });

    }
}
