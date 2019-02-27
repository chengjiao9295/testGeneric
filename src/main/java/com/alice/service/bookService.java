package com.alice.service;

import com.alice.bean.book;

import java.util.List;

public interface bookService {
    List<book> getBookInformation(book book);
}
