package com.test.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.ApinforMapper;
import com.test.model.Apinfor;
import com.test.model.User;
import com.test.service.ApinforService;
import com.test.util.IdGenerateUtils;

@Service("ApinforService")
public class ApinforServiceImpl implements ApinforService {

	@Autowired
    private ApinforMapper apinforDao;
	@Override
	public int insert(Apinfor record) {
		String apinforid = IdGenerateUtils.getId();
		record.setId(apinforid);
		return apinforDao.insert(record);
	}
	@Override
	public List<Apinfor> AllApinfor() {
		
		return apinforDao.AllApinfor();
	}
	@Override
	public int deleteByPrimaryKey(String id) {
		
		return apinforDao.deleteByPrimaryKey(id);
	}
	@Override
	public Apinfor selectByPrimaryKey(String id) {
		
		return apinforDao.selectByPrimaryKey(id);
	}
	@Override
	public int deleteByPrimaryKeybatch(List<String> list) {
		int total=0,j;
		for(int i=0;i<list.size();i++){
			j =apinforDao.deleteByPrimaryKey(list.get(i));
			if(j>0){
				total++;
			}
			
		}
		return total ;
	}
	@Override
	public int updateByPrimaryKeySelective(Apinfor record) {
		
		return apinforDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Apinfor> AllApinforbytwo(Map<String,String> map) {
		// TODO Auto-generated method stub
		return apinforDao.getList(map);
	}

}
