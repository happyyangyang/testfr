package com.test.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.test.model.Apinfor;


public interface ApinforService {
	int insert(Apinfor record);
	
	List<Apinfor> AllApinfor();
	
	PageInfo<Apinfor> AllApinforbytwo(Map<String,String> map);
	
	 int deleteByPrimaryKey(String id);
	 
	 Apinfor selectByPrimaryKey(String id);
	 
	 int deleteByPrimaryKeybatch(List<String> list);
	 int updateByPrimaryKeySelective(Apinfor record);


}
