package com.test.testcase;

import java.io.File;
import java.io.FileWriter;

import org.testng.annotations.Test;

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

	}

}
