package com.test.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.Apinfor;
import com.test.model.Reporter;
import com.test.model.User;
import com.test.service.CaseService;
import com.test.service.ReporterService;

@Controller
@RequestMapping("report")
public class ReporterController {
	
	
	 @Resource  
	 private ReporterService  reporterService; 
	 
	//获取接口所有数据的列表
		@RequestMapping("/getlist")
		@ResponseBody
		public List<Reporter> getlist(HttpServletRequest request){
			User loginUser = (User)request.getSession().getAttribute("loginUser");
			System.out.println("获取list的user："+loginUser);
			if(loginUser!=null){
				List <Reporter> list = reporterService.AllApinfor();
				Date s = list.get(0).getExcdate();
				return reporterService.AllApinfor();
			}
			return null;
			
		}
	 

}
