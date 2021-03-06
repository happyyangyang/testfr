package com.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
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
				return"apilist";
			}
		}
		return"newapi";
		
	}
	
	//新增接口，成功返回列表页，不成功仍停留该页
		@RequestMapping("/newapi")
		@ResponseBody
		public Map<String,String> newapi(@RequestBody Apinfor apinfor,HttpServletRequest request){
			System.out.println(apinfor.getProjectname());
			Map<String,String> map = new HashMap<String,String>();
			User loginUser = (User)request.getSession().getAttribute("loginUser");
			if(loginUser!=null){
				int num = apinforService.insert(apinfor);
				if(num!=0){
					map.put("result", "success");
					
				}else{
					map.put("result", "error");
				}
			}
			return map;
			
		} 
		//新增接口，成功返回列表页，不成功仍停留该页
		@RequestMapping("/deleteapi")
		@ResponseBody
		public Map<String,String> deleteapi(@RequestBody Map<String,String> parm,HttpServletRequest request){
			Map<String,String> map = new HashMap<String,String>();
			User loginUser = (User)request.getSession().getAttribute("loginUser");
			if(loginUser!=null){
				int num = apinforService.deleteByPrimaryKey(parm.get("id"));
				if(num!=0){
					map.put("result", "success");
							
				}else{
					map.put("result", "error");
					}
			}
		return map;
					
		} 
		//批量删除
		//新增接口，成功返回列表页，不成功仍停留该页
				@RequestMapping("/deletebatchapi")
				@ResponseBody
				public Map<String,String> deletebatchapi(@RequestBody  List<String> parm,HttpServletRequest request){
					Map<String,String> map = new HashMap<String,String>();
					User loginUser = (User)request.getSession().getAttribute("loginUser");
					if(loginUser!=null){
						int num = apinforService.deleteByPrimaryKeybatch(parm);
						if(num!=0){
							map.put("result", "success");
									
						}else{
							map.put("result", "error");
							}
					}
				return map;
							
				} 
		//修改保存的信息到数据库
				@RequestMapping("/updatejinterface")
				@ResponseBody
				public Map<String,String> updatejinterface(@RequestBody Apinfor apinfor,HttpServletRequest request){
					Map<String,String> map = new HashMap<String,String>();
					User loginUser = (User)request.getSession().getAttribute("loginUser");
					if(loginUser!=null){
						int num = apinforService.updateByPrimaryKeySelective(apinfor);
						if(num!=0){
							map.put("result", "success");
							
						}else{
							map.put("result", "error");
						}
					}
					return map;
					
				} 		
		
		
		//跳到修改api页面toupdatejsp
		@RequestMapping("/updateapi")
		public String updateapi(String id,HttpServletRequest request){
			Apinfor apinfor = apinforService.selectByPrimaryKey(id);
			//前端也value=“S{Attributename.属性}”
			request.setAttribute("apinfor", apinfor);
			return "updateapi";

		}
		
		//根据项目名、接口名查询
		@RequestMapping("/search")
		public String search(String projectname,String name,HttpServletRequest request){
			
			return name;
			
		}
		
	
		//获取接口所有数据的列表
		@RequestMapping("/getapiname")
		@ResponseBody
		public List<Apinfor> getapiname(HttpServletRequest request){
			List<Apinfor> apilist = null;
			User loginUser = (User)request.getSession().getAttribute("loginUser");
			System.out.println("获取list的user："+loginUser);
			if(loginUser!=null){
				apilist = apinforService.AllApinfor();
				
			}
			return apilist;
			
		}
		
	
		
		
	//获取接口所有数据的列表
	@RequestMapping("/getlist")
	@ResponseBody
	public Map<String,Object> getlist(@RequestBody HashMap<String,String> parm,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Apinfor> apilist = null;
		//String limit  offset
		//每页的数据条数
		String limit = parm.get("limit");
		String offset = parm.get("offset");
		String prjcectname = parm.get("projectname");
		String apiname = parm.get("name");
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		//System.out.println("获取list的user："+loginUser);
		if(loginUser!=null){
			
			   apilist = apinforService.AllApinforbytwo(parm).getList();
			    long total = apinforService.AllApinforbytwo(parm).getTotal();
			    map.put("total", total);
			    map.put("rows",apilist);
			
		}
		return map;
		
	}
	//批量删除接口
	public Map<String,Object> batchDel(@RequestBody Apinfor apinfor){
		Map<String,Object> map = new HashMap<String,Object>();
		
		return null; 
		
	}
	
}
