package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
	public Testcase selectByPrimaryKey(String id) {
		
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

}
