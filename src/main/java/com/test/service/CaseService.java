package com.test.service;

import java.util.List;


import com.test.model.Testcase;
import com.test.vo.CaseVo;

public interface CaseService {
	
	List<Testcase> getlist();
	
	List<CaseVo> getCaseList();
	
	int deleteByPrimaryKey(String id);
	
	int deleteByPrimaryKeybatch(List<String>list);
	
	Testcase selectByPrimaryKey(String id);
	
	int insert(Testcase record);
	

}
