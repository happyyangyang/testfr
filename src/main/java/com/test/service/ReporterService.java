package com.test.service;

import java.util.List;

import com.test.model.Reporter;
import com.test.model.Testcase;

public interface ReporterService {
	int insert(Reporter record);

	List<Reporter> AllApinforbydate(String date);
	
	List<Reporter> AllApinfor();
	
	//批量删除
	int deleteByPrimaryKeybatch(List<String>list);
	//根据id获取
	
	Reporter selectid(String id);

}
