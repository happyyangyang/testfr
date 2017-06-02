package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.User;
import com.test.service.UserService;

@Controller
@RequestMapping("test")
public class TestController {
	
	 @Resource  
	 private UserService userService; 
	 //获取测试的数据列表
	 @RequestMapping("/GetDepartment")
	 @ResponseBody
	 public List<User> GetDepartment(Integer limit, Integer offset, String departmentname, String statu){
		 int total = userService.countUser();
		 List<User> list = new ArrayList<User>();
		 list = userService.AllUser();
		 return list;
	 }
	

}
