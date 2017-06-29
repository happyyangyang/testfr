package com.test.service;

import java.util.List;

import com.test.model.Apinfor;


public interface ApinforService {
	int insert(Apinfor record);
	
	List<Apinfor> AllApinfor();
	
	 int deleteByPrimaryKey(String id);
	 
	 Apinfor selectByPrimaryKey(String id);
	 
	 int deleteByPrimaryKeybatch(List<String> list);
	 int updateByPrimaryKeySelective(Apinfor record);


}
