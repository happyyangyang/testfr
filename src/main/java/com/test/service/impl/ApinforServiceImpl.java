package com.test.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public PageInfo<Apinfor> AllApinforbytwo(Map<String,String> map) {
		int offset = Integer.parseInt(map.get("offset"));
		int limit = Integer.parseInt(map.get("limit"));
		PageHelper.startPage(offset,limit);
		List <Apinfor> apilist = apinforDao.getList(map);
		PageInfo<Apinfor> page = new PageInfo<Apinfor>(apilist);
		return page;
	}

}
