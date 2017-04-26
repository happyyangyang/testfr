package com.test.service.impl;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.UserMapper;
import com.test.model.User;
import com.test.service.UserService;

@Service("userService") 
public class UserServiceImpl implements UserService{

	
	@Autowired
    private UserMapper userDao;


	@Override
	public int selectByusernameAndPwd(String username, String pwd) {
		
		return userDao.selectByusernameAndPwd(username,pwd);
	}


}
