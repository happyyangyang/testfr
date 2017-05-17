package com.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.User;
import com.test.service.UserService;

@Controller
@RequestMapping("user")
public class LoginController {
	
	 @Resource  
	 private UserService userService;  
	 
	 @RequestMapping("/sucess2")
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
	 
	 @RequestMapping("/returnjson")
	 @ResponseBody
	 public Map<String,Object> returnjson(String username,String password,HttpServletRequest request){ 
		 Map<String ,Object> map = new HashMap<String,Object>();
		 User user = new User();
		 user.setUsername(username);
		 user.setPwd(password);
		 int count =userService.selectByusernameAndPwd(username,password);
		 if(count!=0){
			 map.put("result", "sucess");
			 map.put("user", user);
			 List<User> userlist = new ArrayList<User>();
			 userlist = userService.selectByAddress("北京");
			 map.put("userlist", userlist);
			 request.getSession().setAttribute("loginUser",user);
			 return map; 
		 }
		 else{
			 map.put("result", "fail");
			 return map;
			 
		 }
		 
	 }  
	 
	 @RequestMapping("/toregistpage")
	 public String registpage(){
		 return "registerPage";
		 
	 }
	

}
