package com.test.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.test.model.Testcase;
import com.test.vo.CaseVo;

public interface CaseService {
	
	List<Testcase> getlist();
	
	PageInfo<CaseVo> getCaseList(Map<String,String> parm);
	
	int deleteByPrimaryKey(String id);
	
	int deleteByPrimaryKeybatch(List<String>list);
	
	CaseVo selectByPrimaryKey(String id);
	Testcase selectid(String id);
	int insert(Testcase record);
	
	int updateByPrimaryKeySelective(Testcase record);
	//批量生成testng类
	Boolean getbatchexe(List<String>list);
	
	CaseVo selectByid(String id);
	
	
	Boolean execase(String filepath);
	
	
	//直接发请求
	
	Boolean exct(List<String>parm);

}
