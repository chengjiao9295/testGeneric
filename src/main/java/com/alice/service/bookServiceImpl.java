package com.alice.service;

import com.alice.bean.book;
import com.alice.dao.bookMapper;
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

   public List<book> getBookInformation(book param){
      logger.info("getBookInformation()"+param.toString());
      bookMapper mapper = sqlSession.getMapper(bookMapper.class);
      List<book> bookList=mapper.queryBookInfo(param);
     return bookList;
   }


}
