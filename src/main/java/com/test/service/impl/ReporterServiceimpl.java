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
	public List<Reporter> AllApinforbydate(String date) {
		
		return reporterDao.AllApinforbydate(date);
	}

	@Override
	public int deleteByPrimaryKeybatch(List<String> list) {
		int total=0,j;
		for(int i=0;i<list.size();i++){
			j = reporterDao.deleteByPrimaryKey(list.get(i));
			if(j>0){
				total++;
			}
			
		}
		return total ;
	}

	@Override
	public Reporter selectid(String id) {
	
		return reporterDao.selectid(id);
	}

	@Override
	public List<Reporter> AllApinfor() {
		// TODO Auto-generated method stub
		return reporterDao.AllApinfor();
	}
	

}
