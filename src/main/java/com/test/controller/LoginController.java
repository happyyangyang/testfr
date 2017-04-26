package com.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.service.UserService;

@Controller
@RequestMapping("user")
public class LoginController {
	
	 @Resource  
	 private UserService userService;  
	      
	 @RequestMapping("toindex")
	 public String login(String username,String pwd){  
		 int count =userService.selectByusernameAndPwd(username, pwd);
		 if(count!=0){
			 return "index";
		 }
		 else{
			 return "fail" ;
		 }
		 
	 }  

}
