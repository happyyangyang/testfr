package com.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.model.User;
import com.test.service.UserService;

@Controller
@RequestMapping("user")
public class LoginController {
	
	 @Resource  
	 private UserService userService;  
	 
	 @RequestMapping("/sucess")
	 public String sucess(String username,String password,HttpServletRequest request){ 
		 User user = new User();
		 user.setUsername(username);
		 user.setPwd(password);
		 int count =userService.selectByusernameAndPwd(username,password);
		 if(count!=0){
			 
			 request.getSession().setAttribute("loginUser",user);
			 return "index";
		 }
		 else{
			 return "fail";
		 }
		 
	 }  
	 
	 @RequestMapping("/toregistpage")
	 public String registpage(){
		 return "registerPage";
		 
	 }
	

}
