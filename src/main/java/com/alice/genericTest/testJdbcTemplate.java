package com.alice.genericTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.filter.CharacterEncodingFilter;

public class testJdbcTemplate {
    public static void main(String args[]){
        //启动IoC容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("application-mybatis.xml");
       //获取IoC容器中JdbcTemplate实例
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
        String sql="insert into user (name,deptid) values (?,?)";
        int count= jdbcTemplate.update(sql, new Object[]{"caoyc",3});
        System.out.println(count);
    }
}
