package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.test.dao.TestcaseMapper;

import com.test.model.Testcase;
import com.test.service.CaseService;
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

}
