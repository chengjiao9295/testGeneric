package com.alice.service;

import com.alice.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

public class BookServiceImplTest extends BaseTest {
    @Autowired
    private bookService bookService;

    @Test
    public void testAppoint() throws Exception {
         bookService.getBookInformation();

    }
}
