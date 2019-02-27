package com.alice.controller;

import com.alice.bean.book;
import com.alice.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "book")
public class bookController {

    @Autowired
    public bookService bookService;

    @RequestMapping(value = "getBookInfo")
    public List<book> getBookInfo(@ModelAttribute book param){
        List<book> bookList = bookService.getBookInformation(param);
        return bookList;
    }

}
