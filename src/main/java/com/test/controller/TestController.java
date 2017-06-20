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

import com.test.model.Apinfor;
import com.test.model.Testcase;
import com.test.model.User;
import com.test.service.CaseService;
import com.test.service.UserService;
import com.test.vo.CaseVo;



@Controller
@RequestMapping("testCase")
public class TestController {
	
	
	 
	 @Resource  
	 private CaseService  caseService; 
	 

	 
	 //获取列表
	 @RequestMapping("/gettestcaselist")
	 @ResponseBody
	 public List<Testcase> gettestcaselist(HttpServletRequest request){
		 
		 
		 User user = (User)request.getSession().getAttribute("loginUser");
		 if(user!=null){
			 return caseService.getlist();
			 //return caseService.getCaseList();
		 }
		return null;
		
		 
	 }
	//获取列表
		 @RequestMapping("/getcaselist")
		 @ResponseBody
		 public List<CaseVo> getcaselist(HttpServletRequest request){
			 
			 User user = (User)request.getSession().getAttribute("loginUser");
			 if(user!=null){
				 //return caseService.getlist();
				 return caseService.getCaseList();
			 }
			return null;
			
			 
		 }
		 //新增用例
		 
			@RequestMapping("/newtestcase")
			@ResponseBody
			public Map<String,String> newtestcase(@RequestBody Map<String,String> parm,HttpServletRequest request){
				Testcase testcase = new Testcase();
				testcase.setCasename(parm.get("casename"));
				testcase.setScenario(parm.get("scenario"));
				testcase.setParmater(parm.get("parmater"));
				testcase.setExpect(parm.get("expect"));
				testcase.setApiid(parm.get("apiid"));
				Map<String,String> map = new HashMap<String,String>();
				User loginUser = (User)request.getSession().getAttribute("loginUser");
				if(loginUser!=null){
					int num = caseService.insert(testcase);
					if(num!=0){
						map.put("result", "success");
						
					}else{
						map.put("result", "error");
					}
				}
				return map;
				
			} 
			
		 //删除测试用例，成功返回列表页，不成功仍停留该页deletebatchcase
			@RequestMapping("/deletecase")
			@ResponseBody
			public Map<String,String> deletecase(@RequestBody Map<String,String> parm,HttpServletRequest request){
				Map<String,String> map = new HashMap<String,String>();
				User loginUser = (User)request.getSession().getAttribute("loginUser");
				if(loginUser!=null){
					int num = caseService.deleteByPrimaryKey(parm.get("id"));
					if(num!=0){
						map.put("result", "success");
								
					}else{
						map.put("result", "error");
						}
				}
			return map;
						
			}  
			
			//批量删除，成功返回列表页，不成功仍停留该页deletebatchcase
			@RequestMapping("/deletebatchcase")
			@ResponseBody
			public Map<String,String> deletebatchcase(@RequestBody List<String> parm,HttpServletRequest request){
				Map<String,String> map = new HashMap<String,String>();
				User loginUser = (User)request.getSession().getAttribute("loginUser");
				if(loginUser!=null){
					int num = caseService.deleteByPrimaryKeybatch(parm);
					if(num!=0){
						map.put("result", "success");
								
					}else{
						map.put("result", "error");
						}
				}
			return map;
						
			}  
			//跳到修改api页面toupdatejsp
			@RequestMapping("/updatecase")
			public String updatecase(String id,HttpServletRequest request){
				Testcase testcase = caseService.selectByPrimaryKey(id);
				//前端也value=“S{Attributename.属性}”
				request.setAttribute("testcase", testcase);
				return "updatecase";

			}

}
