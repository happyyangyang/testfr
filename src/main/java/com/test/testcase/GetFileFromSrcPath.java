package com.test.testcase;

public class GetFileFromSrcPath {

	public static void main(String[] args) {
		String tempPath = GetFileFromSrcPath.class.getResource("/").getPath();    // 获取了工程中的classes目录(该目录位于webinf下面)

		String webinfPath = tempPath.substring(0, tempPath.lastIndexOf("classes"));
		// 取得webinf的路径
		System.out.println(webinfPath);
		// 在控制台中输出webinf的路径

	}

}
