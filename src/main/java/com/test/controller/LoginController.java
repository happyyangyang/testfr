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
	 
	 @RequestMapping("/valid")
	 public Map<String,String> valid(@RequestBody User user,HttpServletRequest request){
		 HashMap<String,String> map = new HashMap<String,String>();
		 int count =userService.selectByusernameAndPwd(user.getUsername(),user.getPwd());
		 if(count!=0){
			 map.put("result", "success");
			 request.getSession().setAttribute("loginUser",user);
		 }
		 else{
			 map.put("result", "infoError"); ;
		 }
		 
		 return map;
		 
		 
	 }
	 
	 @RequestMapping("/sucess")
	 public String sucess(){  
		 return "index";
	 }  
	 public String fail(){  
		 return "fail";
	 }  

}
