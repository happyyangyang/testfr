package com.test.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.test.model.Testcase;
import com.test.testcase.Exe;

public class ExeTestCase {
	public  void execase(String filepath,String source,String srcdir,String jarpath){
		
				  File f = new File(filepath);
				  FileWriter fw=null;
				try {
					fw = new FileWriter(f);
					 fw.write(source);
					 fw.flush();
					 fw.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}finally{
					
					  
					  
				}
				
		 //编译
				try {
					String encoding ="UTF-8";
					//String jars="D:\\win\\testng-6.9.10.jar";
					//String jars = request.getContextPath()+"\\WEB-INF\\lib\\testng-6.9.10.jar";
					String targetDir="D:\\win";
					//String sourceDir="D:\\win";
					//File systemTempDir = org.apache.commons.io.FileUtils.getTempDirectory();
					
					JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
					StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null,null, null);
					Iterable units = fileMgr.getJavaFileObjects(filepath);
					Iterable<String> options = Arrays.asList("-encoding", encoding, "-classpath", jarpath, "-d",srcdir , "-sourcepath", srcdir);
					CompilationTask t = compiler.getTask(null, fileMgr, null, options, null,units);
					t.call();
					fileMgr.close();
					} catch (IOException e) {

					System.out.println("编译"+e.toString());
					}	
				
		
	
	}

}
