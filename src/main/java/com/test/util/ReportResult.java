package com.test.util;

import java.util.List;

import com.test.util.ExtentTestNGIReporterListener.TestTag;

public  class ReportResult {
	public  int failures =0;
	public  int errors=0;
	public  int testCount=0;
	public  float totalTime=System.currentTimeMillis();
	public  long begantime=0;
	public  StringBuilder text=null;
	public   void  Savereporter(int failures1,int errors1,int testCount1,float totalTime1,long begantime1,StringBuilder text1){
		failures =failures1;
		errors = errors1;
		testCount = testCount1;
		totalTime = totalTime1;
		begantime = begantime1;
		text = text1;
	}
	
}
