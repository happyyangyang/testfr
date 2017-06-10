package com.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.Project;
import com.test.model.User;
import com.test.model.UserDog;
import com.test.model.UserExample;
import com.test.model.UserExample.Criteria;
import com.test.model.UserListForm;
import com.test.model.UserMapForm;
import com.test.model.UserSetForm;
import com.test.service.UserService;

@Controller
@RequestMapping("user")
public class LoginController {
	
	 @Resource  
	 private UserService userService;  
	 
	 //指定请求方法
	 @RequestMapping(value="/sucess",method={RequestMethod.POST,RequestMethod.GET})
	 
	 public String sucess(String username,String pwd,HttpServletRequest request){ 
		 User user = new User();
		 user.setUsername(username);
		 user.setPwd(pwd);
		 int count =userService.selectByusernameAndPwd(username,pwd);
		 if(count!=0){
			 
			 request.getSession().setAttribute("loginUser",user);
			 return "main";
		 }
		 else{
			 return "fail";
		 }
		 
	 }  
	 //参数绑定，简单类型保证jsp中name和controller的形参一直就可以，如果不可以可以用@RequestParam来指定
	 
	 @RequestMapping("/sucessparm")
	 public String sucessparm(String username,@RequestParam(value="pwd")String password,HttpServletRequest request){ 
		 User user = new User();
		 user.setUsername(username);
		 user.setPwd(password);
		 int count =userService.selectByusernameAndPwd(username,password);
		 if(count!=0){
			 
			 request.getSession().setAttribute("loginUser",user);
			 return "main";
		 }
		 else{
			 return "fail";
		 }
		 
	 }  
	 //pojo的绑定
	 //前端中的name和pojo的属性名一致
	 
	 @RequestMapping("/sucesspojo")
	 public String sucesspojo(User user,HttpServletRequest request){ 
		
		 User u =userService.getUserByNameAndPwd(user);
		
		 if(u!=null){
			 
			 request.getSession().setAttribute("loginUser",user);
			 System.out.println("登录user："+request.getSession().getAttribute("loginUser"));
			 return "main";
		 }
		 else{
			 return "fail";
		 }
		 
	 }
	 
	 
	 //退出操作
	 @RequestMapping("/exit")
	 public void exti(HttpServletResponse response,HttpServletRequest request)throws IOException{
		 request.getSession().removeAttribute("loginUser");
		 System.out.println("===========退出的user"+request.getSession().getAttribute("loginUser"));
		 response.sendRedirect(request.getContextPath()+"/login.jsp");
		 
	 }
	 
	 //注册
	 @RequestMapping(value="/register")
	 @ResponseBody
	 public Map<String,String> register(@RequestBody User user,HttpServletRequest request){
		 Map<String,String>map  = new HashMap<String,String>();
		 Map<String,String>arg  = new HashMap<String,String>();
		 arg.put("username", user.getUsername());
		 List<User> list = userService.getUsers(arg);
		 if(list!=null && list.size()>0){
			 map.put("result", "nameIsExist");
			 
		 }else{
			 userService.insert(user);
			 map.put("result", "success");
			
		 }
		 return map;
	 }
	 
	 //自定义符合类型对象绑定
	 @RequestMapping("/userdog")
	 @ResponseBody
	 public Map<String,Object> userdog(UserDog userdog){
		 Map<String,Object> map = new  HashMap<String,Object>();
		 map.put("参数", userdog);
		return map;
		 
	 }
	 //list 绑定
	 @RequestMapping("/ListUser")
	 @ResponseBody
	 public Map<String,Object> ListUser(UserListForm userlist){
		 Map<String,Object> map = new  HashMap<String,Object>();
		 map.put("参数", userlist);
		return map;
		 
	 }
	 //Set绑定
	 
	 @RequestMapping("/SetUsers")
	 @ResponseBody
	 public Map<String,Object> SetUser(UserSetForm userset){
		 Map<String,Object> map = new  HashMap<String,Object>();
		 map.put("参数", userset);
		return map;
		 
	 }
	 
	 //map绑定
	 @RequestMapping("/MapUsers")
	 @ResponseBody
	 public Map<String,User> MapUser(UserMapForm usermap){
		// Map<String,Object> map = new  HashMap<String,Object>();
		// map.put("参数", usermap);
		return usermap.getUserMap();
		 
	 }
	//返回json 
	 @RequestMapping("/returnjson")
	 @ResponseBody
	 public Map<String,Object> returnjson(String username,String pwd,HttpServletRequest request){ 
		 Map<String ,Object> map = new HashMap<String,Object>();
		 User user = new User();
		 user.setUsername(username);
		 user.setPwd(pwd);
		 user.setBirthday(new Date(20170518));
		 int count =userService.selectByusernameAndPwd(username,pwd);
		 if(count!=0){
			 map.put("result", "sucess");
			 map.put("user", user);
			 List<User> userlist = new ArrayList<User>();
			 userlist = userService.selectByAddress("北京");
			 map.put("userlist", userlist);
			 request.getSession().setAttribute("loginUser",user);
			 System.out.println("===========:"+map.get("userlist"));
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
	 //重定向和转发
	 @RequestMapping("/redirect")
	 public String redirect(){
		 
		 return "redirect:sucess.do";
		 
	 }
	 //转发
	 @RequestMapping("/forward")
	 public String forward(){
		 
		 return "forward:sucess.do";
		 
	 }
	 
	    @RequestMapping(value = "saveUser", method = {RequestMethod.POST},consumes="application/json") 
	    @ResponseBody  
	    public void saveUser(@RequestBody List<User> user) { 
	        System.out.println("ceshi");
	    }
	

}
