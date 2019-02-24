package com.alice.service;

import com.alice.bean.book;
import com.alice.dao.bookMapper;
import com.alice.genericTest.GenericTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookServiceImpl implements bookService {
    private Logger logger= LogManager.getLogger(bookServiceImpl.class);

    @Autowired
   public SqlSessionTemplate sqlSession;

   public Integer getBookInformation(){
       logger.info(getBookInformation());
      bookMapper mapper = sqlSession.getMapper(bookMapper.class);
      List<book> bookList=mapper.queryBookInfo();
       for (int i = 0; i <bookList.size() ; i++) {
           System.out.println(bookList.get(i).getBook_id());
       }

     return null;
   }


}
