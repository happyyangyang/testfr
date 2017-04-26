package com.test.service;

import com.test.model.User;

public interface UserService {
	public int selectByusernameAndPwd(String username,String pwd);
}
