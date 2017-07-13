package com.test.util;

public  class ReportResult {
	public static int failures =0;
	public static int errors=0;
	public static int testCount=0;
	public static float totalTime=System.currentTimeMillis();
	public static long begantime=0;
	public static  void  Savereporter(int failures1,int errors1,int testCount1,float totalTime1,long begantime1){
		failures =failures1;
		errors = errors1;
		testCount = testCount1;
		totalTime = totalTime1;
		begantime = begantime1;
	}
	
}
