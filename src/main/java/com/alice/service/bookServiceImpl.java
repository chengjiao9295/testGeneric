package com.alice.service;

import com.alice.bean.book;
import com.alice.dao.bookMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
public class bookServiceImpl implements bookService, ApplicationContextAware, Serializable {
    private static final long serialVersionUID = -2502425677681231536L;
    private Logger logger= LogManager.getLogger(bookServiceImpl.class);

    private ApplicationContext context;
    @Autowired
    public SqlSessionTemplate sqlSession;

    @Autowired
    @Qualifier("dataSource")
    public DataSource dataSource;

    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
        return jdbcTemplate;
    }

    public <T> T getBean(Class<T> clazz){
        logger.info("getbean");
        Map<String, T> beansOfType= context.getBeansOfType(clazz,false,true);
        System.out.println(beansOfType.entrySet());
        T bean = context.getBean(clazz);
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context =applicationContext;
    }

   public List<book> getBookInformation(book param){
      logger.info("getBookInformation()"+param.toString());
      bookMapper mapper = sqlSession.getMapper(bookMapper.class);
      List<book> bookList=mapper.queryBookInfo(param);
      bookServiceImpl contextBean=  (bookServiceImpl) context.getBean(bookServiceImpl.class);
      System.out.println(contextBean);
      getJdbcTemplate();
      getBean(bookService.class);

     return bookList;
   }


}
