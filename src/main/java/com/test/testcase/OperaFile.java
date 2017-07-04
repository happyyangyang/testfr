package com.test.testcase;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OperaFile {

	public static void main(String[] args) {
		 OperaFile operaFile = new OperaFile();  
	        operaFile.writeFile("jjjjjjjjjjjjjjj\r\neeeeeeee");

	}
	public void writeFile(String content) {  
        try {  
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./src/main/config/weibo_url.txt"),"UTF-8"));  
            out.write(content);  
            out.newLine();  
            out.flush();  
            out.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}
