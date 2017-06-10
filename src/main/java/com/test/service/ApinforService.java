package com.test.service;

import java.util.List;

import com.test.model.Apinfor;


public interface ApinforService {
	int insert(Apinfor record);
	
	List<Apinfor> AllApinfor();

}
