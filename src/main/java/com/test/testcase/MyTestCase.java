package com.test.testcase;
import org.testng.annotations.Test;

public class MyTestCase
{
@Test
public void function()
{
	String fileName = System.getProperty("user.dir");
	System.out.println(fileName);
}
}