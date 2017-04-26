package com.unit.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import com.test.model.User;
import com.test.service.UserService;

 
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	private ApplicationContext applicationContext;  
     
	//@Resource  
  //  private UserService userService = null;  
  @Test
  public void test() {
	  applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");  
	  UserService userService = (UserService) applicationContext.getBean("userService"); 
	  int count = userService.selectByusernameAndPwd("admin", "123456");
	  logger.info("user的用户名"+count);
	  System.out.println(count);
  }
}
