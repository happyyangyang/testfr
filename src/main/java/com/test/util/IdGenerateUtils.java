package com.test.util;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

public class IdGenerateUtils {
	/**
	 * 获取生成的唯一标识id
	 * @return
	 */
	public static String getId(){
		Date date = new Date();
		String id = DateFormatUtils.format(date,"yyyyMMddHHmmssSSS")+MathUtils.getCharAndNum(8);
		return id;
	}



}
