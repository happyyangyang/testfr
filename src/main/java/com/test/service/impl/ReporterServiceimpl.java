package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.ReporterMapper;
import com.test.dao.UserMapper;
import com.test.model.Reporter;
import com.test.service.ReporterService;

@Service("reporterService") 
public class ReporterServiceimpl implements ReporterService {
	
	@Autowired
    private ReporterMapper reporterDao;
	
	@Override
	public int insert(Reporter record) {
		
		return reporterDao.insert(record);
	}

	@Override
	public List<Reporter> AllApinfor() {
		
		return reporterDao.AllApinfor();
	}
	

}
