package com.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.Apinfor;
import com.test.model.User;
import com.test.service.ApinforService;
import com.test.service.UserService;

@Controller
@RequestMapping("interface")
public class ProjectController {
	
	@Autowired  
	 private ApinforService apinforService; 
	
	@RequestMapping("/new")
	public String newinterface(Apinfor apinfor,HttpServletRequest request){
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		if(loginUser!=null){
			int num = apinforService.insert(apinfor);
			if(num!=0){
				return"newHttp";
			}
		}
		return"new";
		
	}
	
	
}
