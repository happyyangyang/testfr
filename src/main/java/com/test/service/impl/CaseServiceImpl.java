package com.test.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.TestNG;

import com.test.dao.TestcaseMapper;

import com.test.model.Testcase;
import com.test.service.CaseService;
import com.test.util.IdGenerateUtils;
import com.test.vo.CaseVo;

@Service("CaseService") 
public class CaseServiceImpl implements CaseService {
	
	@Autowired
    private TestcaseMapper caseDao;
	@Override
	public List<Testcase> getlist() {
		
		return caseDao.getlist();
	}
	@Override
	public List<CaseVo> getCaseList() {
		
		return caseDao.getCaseList();
	}
	@Override
	public int deleteByPrimaryKey(String id) {
		
		return caseDao.deleteByPrimaryKey(id);
	}
	@Override
	public CaseVo selectByPrimaryKey(String id) {
		
		return caseDao.selectByPrimaryKey(id);
	}
	@Override
	public int insert(Testcase record) {
		String caseid = IdGenerateUtils.getId();
		record.setId(caseid);
		return caseDao.insert(record);
	}
	@Override
	public int deleteByPrimaryKeybatch(List<String> list) {
		int total=0,j;
		for(int i=0;i<list.size();i++){
			j = caseDao.deleteByPrimaryKey(list.get(i));
			if(j>0){
				total++;
			}
			
		}
		return total ;
	}
	//批量生成testng类
	@Override
	public Boolean getbatchexe(List<String> list) {
		Boolean flag = false;
		List<Testcase> cases = new ArrayList<Testcase>();
		for(int i=0;i<list.size();i++){
			Testcase testcase = caseDao.selectByPrimaryKey(list.get(i)) ;
			cases.add(testcase);
		}
		String rt = "\r\n";
		String tab ="\t";
		  
		  
		  StringBuilder method = new StringBuilder();
		  for(int i=0;i<cases.size();i++){
			  String s = "public void " + cases.get(i).getCasename()+"()" +"{"+rt
					  + "  System.out.println(\"price markup....\");"+ rt
					    + "  s.sell();" + " }";
			method.append(s);	  
		  }
		  String source = "package com.test.testcase;" + ""+ rt
				    + "public class MyTestCase"+ rt  + "{"+ rt  + "private String s;" + rt +
				    "public MyTestCase(String s)"+ rt  + " {" + "  this.s = s;"+ rt
				    + " }" + rt +

				   method + rt+
				    "}";
		  String fileName = "classpath://com//test//testcase//MyTest.java";
				  File f = new File(fileName);
				  FileWriter fw=null;
				try {
					fw = new FileWriter(f);
					 fw.write(source);
					 fw.flush();
					 fw.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}finally{
					
					  
					  
				}
				
		  
		return null;
	}
	@Override
	public CaseVo selectByid(String id) {
	
		return caseDao.selectByid(id);
	}
	@Override
	public int updateByPrimaryKeySelective(Testcase record) {
		// TODO Auto-generated method stub
		return caseDao.updateByPrimaryKey(record);
	}
	@Override
	public Boolean execase(String filepath) {
		TestNG testng = new TestNG();
		
		//testng.setTestJar(jarPath);
		List suites = new ArrayList();
		suites.add(filepath);//path to xml..
		testng.setTestSuites(suites);
	//	testng.addListener(new TestListenerAdapter());
		testng.run();
		return null;
	}

}
