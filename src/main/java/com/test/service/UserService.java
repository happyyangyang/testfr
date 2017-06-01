package com.test.service;

import java.util.List;

import com.test.model.User;
import com.test.model.UserExample;

public interface UserService {
	public int selectByusernameAndPwd(String username,String pwd);
	
	public List<User> selectByAddress(String Address);
	
	
	List<User> selectByExample(UserExample example);
	
	int countUser();
	
	List<User> AllUser();
}
