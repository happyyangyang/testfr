package com.test.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.IReporter;
import org.testng.TestNG;
import org.testng.reporters.SuiteHTMLReporter;
import org.testng.xml.XmlSuite;

import com.test.dao.ReporterMapper;
import com.test.dao.TestcaseMapper;
import com.test.model.Reporter;
import com.test.model.Testcase;
import com.test.service.CaseService;
import com.test.util.IdGenerateUtils;
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
			TestNG testng = new TestNG();
			List suites = new ArrayList();
			suites.add(filepath);//path to xml..
			testng.setTestSuites(suites);
		//	testng.addListener(new TestListenerAdapter());
			testng.run();
			flag = true;
			Reporter  record = new Reporter();
			record.setId(IdGenerateUtils.getId());
			record.setTotalcount(ReportResult.testCount);
			record.setFailurescount(ReportResult.failures);
			record.setTotaltime(String.valueOf(ReportResult.totalTime));
			record.setErrorcount(ReportResult.errors);
			Date d = new Date(ReportResult.begantime);
			record.setExcdate(d);
			record.setSuccesscount(ReportResult.testCount-ReportResult.failures-ReportResult.errors);
			record.setSkipscount(ReportResult.testCount-ReportResult.failures-ReportResult.errors-record.getSuccesscount());
			//double percent = record.getSuccesscount()/record.getTotalcount()*100.0;
			double success = record.getSuccesscount().doubleValue();
			record.setSuccesspercent(success/record.getTotalcount());
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
	
	
}
