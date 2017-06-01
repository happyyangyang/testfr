package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.ApinforMapper;
import com.test.model.Apinfor;
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

}
