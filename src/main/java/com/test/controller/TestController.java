package com.test.controller;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.testng.Assert;
import org.testng.TestNG;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
		 public List<CaseVo> getcaselist(@RequestBody Map<String,String> parm,HttpServletRequest request){
			 
			 User user = (User)request.getSession().getAttribute("loginUser");
			 if(user!=null){
				 //return caseService.getlist();
				 return caseService.getCaseList(parm);
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
				testcase.setExpectkey1(parm.get("expectkey1"));
				testcase.setExpectvalue1(parm.get("expectvalue1"));
				testcase.setExpectkey2(parm.get("expectkey2"));
				testcase.setExpectvalue2(parm.get("expectvalue2"));
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
			
			//批量执行请求不在生成testng类
			@RequestMapping("/exct")
			@ResponseBody
			public Map<String,String> exct(@RequestBody List<String> parm,HttpServletRequest request){
				Map<String,String> map = new HashMap<String,String>();
				User loginUser = (User)request.getSession().getAttribute("loginUser");
				if(loginUser!=null){
					boolean num = caseService.exct(parm);
					if(num){
						map.put("result", "success");
								
					}else{
						map.put("result", "error");
						}
				}
			return map;
						
			}  
			//单挑执行
			@RequestMapping("/exctSingle")
			@ResponseBody
			public Map<String,String> exctSingle(String id,HttpServletRequest request){
				Map<String,String> map = new HashMap<String,String>();
				User loginUser = (User)request.getSession().getAttribute("loginUser");
				List<String> parm = new ArrayList<String>();
				parm.add(id);
				if(loginUser!=null){
					boolean num = caseService.exct(parm);
					if(num){
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
				testcase.setExpectkey1(parm.get("expectkey1"));
				testcase.setExpectvalue1(parm.get("expectvalue1"));
				testcase.setExpectkey2(parm.get("expectkey2"));
				testcase.setExpectvalue2(parm.get("expectvalue2"));
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
				CaseVo casevo = caseService.selectByPrimaryKey(id);
				//前端也value=“S{Attributename.属性}”
				request.setAttribute("casevo", casevo);
				
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
				//发送http请求的jar包
				String jarpath2 = request.getSession().getServletContext().getRealPath("/WEB-INF/lib/yhq.jar");
				//解析json的jar包
				String jarpath3 = request.getSession().getServletContext().getRealPath("/WEB-INF/lib/fastjson-1.2.8.jar");
				//获取运行环境的操作系统
				String os = System.getProperty("os.name");  
				System.out.println(os);
				String jarpath;
				if(os.contains("Windows")){
					jarpath = jarpath1+";"+jarpath2+";"+jarpath3;
				}else{
					jarpath = jarpath1+":"+jarpath2+":"+jarpath3;
				}
			
						
				System.out.println("webinf的路径："+syhq);
				Map<String,String> map = new HashMap<String,String>();
				
				User loginUser = (User)request.getSession().getAttribute("loginUser");
				if(loginUser!=null){
					try{
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
									  "httpurl = new MyHttpUrlConnect();"+rt+tab+" String respose = httpurl.postrawBody(\""
									  		+ ""+cases.get(i).getUrl()+"\","+"\""+
									  cases.get(i).getParmater()+"\""+");"+rt+tab
									  + " JSONObject json = JSON.parseObject(respose);"+ rt+tab+"System.out.println(respose);"+rt+tab+
									  "String s = json.getString(\""+cases.get(i).getExpectkey1()+"\");"+rt+tab+"Assert.assertEquals(s,"+"\""+cases.get(i).getExpectvalue1()+"\""+");"
									   + " }"+rt;
							method.append(s);	  
						  }
						  String imp ="import org.testng.annotations.Test;"+rt+"import com.test.util.MyHttpUrlConnect;"+rt+"import org.testng.Assert;"
								  		+"import com.alibaba.fastjson.*;";
						  //"package com.test.testcase;"
						  String source =  "package com.test.testcase;"+ rt+imp+rt
								    + "public class MyTest"+ rt  + "{" + rt + "MyHttpUrlConnect httpurl = null;"+rt+
								    method + rt+
								    "}";
						  
						  ExeTestCase ec = new ExeTestCase();
						  //String  s =ExeTestCase.class.getClassLoader().getResource("MyTest.java").getPath();
						  //编译
						  ec.execase(syhq,source,srcdir,jarpath);
						  map.put("result", "success");
					}
					catch(Exception e){
						
						map.put("result", "error");
					}
				}
			return map;
						
			}  
			//执行批量文件
			@RequestMapping("/exebatchcase")
			@ResponseBody
			public Map<String,String> exebatchcase(HttpServletRequest request){
				Map<String,String> map = new HashMap<String,String>();
				//String path = request.getSession().getServletContext().getRealPath("com.test.testcase");
				User loginUser = (User)request.getSession().getAttribute("loginUser");
				//testng.xml的路径
				String path = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/testng.xml");
				if(loginUser!=null){
					
					Boolean flag = caseService.execase(path);
					if(flag){
						map.put("result", "success"); 
					}else{
						map.put("result", "error");
					}
				}
				return map;
						
			}  
			
			//批量导入用例
			@RequestMapping("/importexcel")
			public String importexcel(HttpServletRequest request,@RequestParam MultipartFile file){
				Map<String,String> map = new HashMap<String,String>();
				//String path = request.getSession().getServletContext().getRealPath("com.test.testcase");
				User loginUser = (User)request.getSession().getAttribute("loginUser");
				//上传到服务的路径
				String path = request.getSession().getServletContext().getRealPath("upload");
				if(loginUser!=null){
					try{
						String url = path+"/"+System.currentTimeMillis()+file.getOriginalFilename();
						System.out.println("上传到服务器的路径："+url);
						file.transferTo(new File(url));
						//读取excel并打入数据库
						start(url);
						
						
						
					}catch(Exception e){
						
						e.printStackTrace();
					}
				}
				return "testcaselist";
						
			}  
			
			//读取excel并入库
			public void start(String excelurl){
				Map<String,String> map = new HashMap<String,String>();
				try {
					XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(excelurl)));
					XSSFSheet sheet = workbook.getSheetAt(0);
					//获取总行数
					int rowtotal = sheet.getLastRowNum()-sheet.getFirstRowNum()+1;
					String [][] result = new String[rowtotal][]; 
					//标题不能算入
					for(int rowindex=1;rowindex<=sheet.getLastRowNum();rowindex++){
						XSSFRow row = sheet.getRow(rowindex);
						//获取总列数
						int celltotal = row.getLastCellNum()+1;
						String [] str = new String[celltotal];
						//读取列
						for(int colindex=0;colindex<row.getLastCellNum();colindex++){
							XSSFCell cell = row.getCell(colindex);
							result[rowindex] = str;
							result[rowindex][colindex] = cell.getStringCellValue();
							
						}
					}
					
					//入库
					
					for(int i=1;i<result.length;i++){
						int cellnum = result[i].length;
						List<String>list = new ArrayList<String>();
						Testcase testcase = new Testcase();
						//表格列的位置固定
						for(int j=0;j<cellnum;j++){
							list.add(result[i][j]);
						}
						testcase.setCasename(list.get(0));
						testcase.setScenario(list.get(1));
						testcase.setParmater(list.get(2));
						testcase.setExpectkey1(list.get(3));
						testcase.setApiid(list.get(4));
						caseService.insert(testcase);
						
					}
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
}
