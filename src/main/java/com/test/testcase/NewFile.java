package com.test.testcase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import org.testng.annotations.Test;

import com.beust.testng.TestNG;

public class NewFile {

	public static void main(String[] args) throws Exception {
		String rt = "\r\n";
		String tab ="\t";
		  String source = "package com.test.testcase;" + ""+ rt
		    + "public class MyTestCase"+ rt  + "{"+ rt  + "private String s;" + rt +
		    "public MyTestCase(String s)"+ rt  + " {" + "  this.s = s;"+ rt
		    + " }" + rt +

		    " public void sell()" + " {"+ rt
		    + "  System.out.println(\"price markup....\");"+ rt
		    + "  s.sell();" + " }" + rt+
		    "}";
		  
		  String  testngfile ="package com.test.testcase;"+rt+
				  "import org.testng.annotations.Test;"+rt+rt+
				  "public class MyTestCase" +rt +"{"+rt+"@Test"+rt+
				  "public void function()"+rt+"{"+rt+tab+"String fileName = System.getProperty(\"user.dir\");"+rt+tab+
				  "System.out.println(fileName);"+rt+"}"+rt+"}";
				  
		  String fileName = System.getProperty("user.dir")//获取到项目的根路径
				    + "//src//main//java//com//test//testcase//MyTestCase.java";
				  File f = new File(fileName);
				  FileWriter fw = new FileWriter(f);
				  fw.write(testngfile);
				  fw.flush();
				  fw.close();
				  
				  //编译
					try {
						JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
						StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null,null, null);
						Iterable units = fileMgr.getJavaFileObjects(fileName);
						CompilationTask t = compiler.getTask(null, fileMgr, null, null, null,units);
						t.call();
						fileMgr.close();
						} catch (IOException e) {

						System.out.println("编译"+e.toString());
						}	
			 
	}

}
