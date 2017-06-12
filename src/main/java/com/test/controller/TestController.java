package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.Testcase;
import com.test.model.User;
import com.test.service.CaseService;
import com.test.service.UserService;

@Controller
@RequestMapping("testCase")
public class TestController {
	
	
	 
	 @Resource  
	 private CaseService  caseService; 
	 
	 //获取测试的数据列表
//	 @RequestMapping("/GetDepartment")
//	 @ResponseBody
//	 public List<User> GetDepartment(Integer limit, Integer offset, String departmentname, String statu){
//		 int total = userService.countUser();
//		 List<User> list = new ArrayList<User>();
//		 list = userService.AllUser();
//		 return list;
//	 }
	//新建测试用例
	
	 
	 //获取列表
	 @RequestMapping("/gettestcaselist")
	 @ResponseBody
	 public List<Testcase> gettestcaselist(HttpServletRequest request){
		 
		 User user = (User)request.getSession().getAttribute("loginUser");
		 if(user!=null){
			 return caseService.getlist();
		 }
		return null;
		
		 
	 }

}
