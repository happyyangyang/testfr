package com.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//新增接口，成功返回列表页，不成功仍停留该页
	@RequestMapping("/new")
	public String newinterface(Apinfor apinfor,HttpServletRequest request){
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		if(loginUser!=null){
			int num = apinforService.insert(apinfor);
			if(num!=0){
				//返回列表页
				return"newHttp";
			}
		}
		return"new";
		
	}
	//获取接口所有数据的列表
	@RequestMapping("/getlist")
	@ResponseBody
	public List<Apinfor> getlist(HttpServletRequest request){
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		System.out.println("获取list的user："+loginUser);
		if(loginUser!=null){
			return apinforService.AllApinfor();
		}
		return null;
		
	}
	//批量删除接口
	public Map<String,Object> batchDel(@RequestBody Apinfor apinfor){
		Map<String,Object> map = new HashMap<String,Object>();
		
		return null; 
		
	}
	
}
