package com.test.controller;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.testng.TestNG;

import com.test.model.Apinfor;
import com.test.model.Testcase;
import com.test.model.User;
import com.test.service.CaseService;
import com.test.service.UserService;
import com.test.testcase.Exe;
import com.test.util.ExeTestCase;
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
			
			//更新用例updatetestcase

			@RequestMapping("/updatetestcase")
			@ResponseBody
			public Map<String,String> updatetestcase(@RequestBody Map<String,String> parm,HttpServletRequest request){
				Testcase testcase = new Testcase();
				testcase.setId(parm.get("id"));
				testcase.setCasename(parm.get("casename"));
				testcase.setScenario(parm.get("scenario"));
				testcase.setParmater(parm.get("parmater"));
				testcase.setExpect(parm.get("expect"));
				testcase.setApiid(parm.get("apiid"));
				Map<String,String> map = new HashMap<String,String>();
				User loginUser = (User)request.getSession().getAttribute("loginUser");
				if(loginUser!=null){
					int num = caseService.updateByPrimaryKeySelective(testcase);
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
				//CaseVo casevo = caseService.selectByid(id);
				Testcase testcase = caseService.selectByPrimaryKey(id);
				//前端也value=“S{Attributename.属性}”
				request.setAttribute("testcase", testcase);
				
				return "updatecase";

			}
			//批量生成可执行文件
			
			@RequestMapping("/getexebatchcase1")
			@ResponseBody
			public Map<String,String> getexebatchcase1(@RequestBody List<String> parm,HttpServletRequest request){
				System.out.println(request.getContextPath());
				//类的位置
				String syhq = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/MyTest.java");
				String srcdir=request.getSession().getServletContext().getRealPath("/WEB-INF/classes");
				//获得testng包
				String jarpath1 = request.getSession().getServletContext().getRealPath("/WEB-INF/lib/testng-6.9.10.jar");
				String jarpath2 = request.getSession().getServletContext().getRealPath("/WEB-INF/lib/yhq.jar");
				String jarpath = jarpath1+";"+jarpath2;
						
				System.out.println("webinf的路径："+syhq);
				Map<String,String> map = new HashMap<String,String>();
				
				User loginUser = (User)request.getSession().getAttribute("loginUser");
				if(loginUser!=null){
					Boolean flag = false;
					List<CaseVo> cases = new ArrayList<CaseVo>();
					for(int i=0;i<parm.size();i++){
						CaseVo testcase = caseService.selectByPrimaryKey(parm.get(i)) ;
						cases.add(testcase);
					}

					
					String rt = "\r\n";
					String tab ="\t";
					  
					  
					  StringBuilder method = new StringBuilder();
					  for(int i=0;i<cases.size();i++){
						  String s = "@Test"+rt+"public void " + cases.get(i).getCasename()+"()" +"{"+rt+tab+
								  "httpurl = new MyHttpUrlConnect();"+rt+tab+" String res = httpurl.postrawBody(\""
								  		+ ""+cases.get(i).getUrl()+"\","+"\""+
								  cases.get(i).getParmater()+"\""+");"+rt+tab
								  + "  System.out.println(res);"+ rt
								   + " }"+rt;
						method.append(s);	  
					  }
					  String imp ="import org.testng.annotations.Test;"+rt+"import com.test.util.MyHttpUrlConnect;";
					  //"package com.test.testcase;"
					  String source =  "package com.test.testcase;"+ rt+imp+rt
							    + "public class MyTest"+ rt  + "{" + rt + "MyHttpUrlConnect httpurl = null;"+rt+
							    method + rt+
							    "}";
					  
					  ExeTestCase ec = new ExeTestCase();
					  //String  s =ExeTestCase.class.getClassLoader().getResource("MyTest.java").getPath();
					  ec.execase(syhq,source,srcdir,jarpath);
				}
			return map;
						
			}  
			
			@RequestMapping("/exebatchcase")
			@ResponseBody
			public Map<String,String> exebatchcase(HttpServletRequest request){
				Map<String,String> map = new HashMap<String,String>();
				//String path = request.getSession().getServletContext().getRealPath("com.test.testcase");
				User loginUser = (User)request.getSession().getAttribute("loginUser");
				String path = "D:\\win\\testng.xml";
				if(loginUser!=null){
					Boolean flag = caseService.execase(path);
				}
				return map;
						
			}  

}
