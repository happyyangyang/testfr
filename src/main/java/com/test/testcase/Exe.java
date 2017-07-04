package com.test.testcase;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;



public class Exe {

	public static void main(String[] args) {
		TestNG testng = new TestNG();
		List suites = new ArrayList();
		suites.add("D:/win/testng.xml");//path to xml..
		testng.setTestSuites(suites);
	//	testng.addListener(new TestListenerAdapter());
		testng.run();

	}

}
