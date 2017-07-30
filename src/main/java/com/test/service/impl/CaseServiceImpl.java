package com.test.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.TestNG;
import org.testng.reporters.SuiteHTMLReporter;
import org.testng.xml.XmlSuite;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.dao.ReporterMapper;
import com.test.dao.TestcaseMapper;
import com.test.model.Reporter;
import com.test.model.Testcase;
import com.test.service.CaseService;
import com.test.util.IdGenerateUtils;
import com.test.util.MyHttpUrlConnect;
import com.test.util.ReportResult;
import com.test.vo.CaseVo;

@Service("CaseService") 
public class CaseServiceImpl implements CaseService {
	
	@Autowired
    private TestcaseMapper caseDao;
	
	@Autowired
    private ReporterMapper reporterDao;
	
	@Override
	public List<Testcase> getlist() {
		
		return caseDao.getlist();
	}
	@Override
	public List<CaseVo> getCaseList(Map<String,String> parm) {
		
		return caseDao.getCaseList(parm);
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
		
		Boolean flag = false;
		try{
			//添加testng.xml
			TestNG testng = new TestNG();
			List suites = new ArrayList();
			suites.add(filepath);//path to xml..
			testng.setTestSuites(suites);
		//	testng.addListener(new TestListenerAdapter());
			testng.run();
			flag = true;
			Reporter  record = new Reporter();
			record.setId(IdGenerateUtils.getId());
//			record.setTotalcount(ReportResult.testCount);
//			record.setFailurescount(ReportResult.failures);
//			record.setTotaltime(String.valueOf(ReportResult.totalTime));
//			record.setErrorcount(ReportResult.errors);
//			Date d = new Date(ReportResult.begantime);
//			record.setExcdate(d);
//			record.setSuccesscount(ReportResult.testCount-ReportResult.failures-ReportResult.errors);
//			record.setSkipscount(ReportResult.testCount-ReportResult.failures-ReportResult.errors-record.getSuccesscount());
//			record.setText(ReportResult.text.toString());
			
			double success = record.getSuccesscount().doubleValue();
			record.setSuccesspercent(success/record.getTotalcount()*100);
			reporterDao.insert(record);
			
		}catch(Exception e){
			System.out.println("执行用例中发生错误");
		}
		
		return flag;
	}
	@Override
	public Testcase selectid(String id) {
		// TODO Auto-generated method stub
		return caseDao.selectid(id);
	}
	@Override
	public Boolean getbatchexe(List<String> list) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean exct(List<String> parm) {
		long beagintime = System.currentTimeMillis();
		int successcount =0;
		//每条用例
		List<HashMap<String,String>> testcas;
		List<CaseVo> cases =new ArrayList<CaseVo>();
		StringBuilder result=new StringBuilder();
		for(int i=0;i<parm.size();i++){
			cases.add(caseDao.selectByid(parm.get(i)));
		}
		if(!cases.isEmpty()){
			MyHttpUrlConnect http = new MyHttpUrlConnect();
			for(int i=0;i<cases.size();i++){
				String s =http.postrawBody(cases.get(i).getUrl(), cases.get(i).getParmater());
				//System.out.println(s);
				String value1 = cases.get(i).getExpectvalue1();
				String key1 = cases.get(i).getExpectkey1();
				String value2= cases.get(i).getExpectvalue2();
				String key2 = cases.get(i).getExpectkey2();
				//获取断言字段
				if(value1!=null && key1!=null){
					if(!value1.isEmpty()&&!key1.isEmpty()){
						JSONObject jsonobject = JSON.parseObject(s);
						String reall = jsonobject.getString(cases.get(i).getExpectkey1());
						if(reall!=null){
							if(reall.equalsIgnoreCase(cases.get(i).getExpectvalue1())){
								//成功条数+1
								successcount++;
							}
						}else{
							System.out.println("断言字段在返回报文中不存在，请检查");
						}
						
					}
					
				}else if(value2!=null && key2!=null) {
					if(!value2.isEmpty()&&!key2.isEmpty()){
						JSONObject jsonobject = JSON.parseObject(s);
						String reall = jsonobject.getString(cases.get(i).getExpectkey1());
						if(reall!=null){
							if(reall.equalsIgnoreCase(cases.get(i).getExpectvalue1())){
								//成功条数+1
								successcount++;
							}
						}else{
							System.out.println("断言字段在返回报文中不存在，请检查");
						}
						
					}
					
					
				}else{
					System.out.println("两个断言字段中有空");
				}
				result.append(s);
			}
		}
		long endtime = System.currentTimeMillis();
		 
		long time = endtime - beagintime;
		int totalcount = cases.size();
		System.out.println("所用时间"+time);
		System.out.println("总用例数"+totalcount);
		
		//插入数据库
		Reporter record = new Reporter();
		record.setTotalcount(totalcount);
		record.setSuccesscount(successcount);
		record.setTotaltime(String.valueOf(time));
		Date d = new Date(beagintime);
		record.setExcdate(d);
		record.setFailurescount(totalcount-successcount);
		record.setSuccesspercent(successcount*100.0/totalcount);
		record.setText(result.toString());
		record.setId(IdGenerateUtils.getId());
		
		reporterDao.insert(record);
		return true;
	}
	
	
}
