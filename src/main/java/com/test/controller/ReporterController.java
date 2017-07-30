package com.test.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.Apinfor;
import com.test.model.Reporter;
import com.test.model.Testcase;
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
		public List<Reporter> getlist(@RequestBody HashMap<String,String> parm,HttpServletRequest request){
			List<Reporter> reporters = null;
			User loginUser = (User)request.getSession().getAttribute("loginUser");
			System.out.println("获取list的user："+loginUser);
			if(loginUser!=null){
				//按时间查询
				//List <Reporter> list = reporterService.AllApinfor();
				//Date s = list.get(0).getExcdate();
				String date = parm.get("date");
				
				if(date.isEmpty()){
					reporters = reporterService.AllApinfor();
				}else{
					reporters = reporterService.AllApinforbydate(parm.get("date"));
				}
			}
			return reporters;
			
		}
		
		
		//批量删除，成功返回列表页，不成功仍停留该页deletebatchcase
		@RequestMapping("/deletebatchReporter")
		@ResponseBody
		public Map<String,String> deletebatchReporter(@RequestBody List<String> parm,HttpServletRequest request){
			Map<String,String> map = new HashMap<String,String>();
			User loginUser = (User)request.getSession().getAttribute("loginUser");
			if(loginUser!=null){
				int num = reporterService.deleteByPrimaryKeybatch(parm);
				if(num!=0){
					map.put("result", "success");
							
				}else{
					map.put("result", "error");
					}
			}
		return map;
					
		}  
		
		//批量删除，成功返回列表页，不成功仍停留该页deletebatchcase
		@RequestMapping("/detail")
		public String detail(String id,HttpServletRequest request){
			//CaseVo casevo = caseService.selectByid(id);
			Reporter reporter = reporterService.selectid(id);
			//前端也value=“S{Attributename.属性}”
			request.setAttribute("reporter", reporter);
			
			return "detail";
					
		}  
		
		
	 

}
