package com.alice.controller;

import com.alice.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class bookController {

    @Autowired
    public bookService bookService;
    

}
