package com.test.service;

import java.util.List;


import com.test.model.Testcase;
import com.test.vo.CaseVo;

public interface CaseService {
	
	List<Testcase> getlist();
	
	List<CaseVo> getCaseList();
	
	int deleteByPrimaryKey(String id);
	
	int deleteByPrimaryKeybatch(List<String>list);
	
	CaseVo selectByPrimaryKey(String id);
	
	int insert(Testcase record);
	
	int updateByPrimaryKeySelective(Testcase record);
	//批量生成testng类
	Boolean getbatchexe(List<String>list);
	
	CaseVo selectByid(String id);
	
	
	Boolean execase(String filepath);

}
