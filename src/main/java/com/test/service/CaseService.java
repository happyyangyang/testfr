package com.test.service;

import java.util.List;


import com.test.model.Testcase;
import com.test.vo.CaseVo;

public interface CaseService {
	
	List<Testcase> getlist();
	
	List<CaseVo> getCaseList();
}
