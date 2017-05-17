package com.test.service;

import java.util.List;

import com.test.model.User;

public interface UserService {
	public int selectByusernameAndPwd(String username,String pwd);
	
	public List<User> selectByAddress(String Address);
}
