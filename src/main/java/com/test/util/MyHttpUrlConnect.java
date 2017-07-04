package com.test.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class MyHttpUrlConnect {
	
	HttpURLConnection conn = null;
    BufferedReader rd = null ;
    StringBuilder sb = new StringBuilder ();
    String line = null ;
    String response = null;

	//Get方法
	
	 public String get(String url){
	        
	        try {
	            conn = (HttpURLConnection) new URL(url).openConnection();
	          
	            conn.setRequestMethod("GET");
	            conn.setDoInput(true);
	            conn.setReadTimeout(20000);
	            conn.setConnectTimeout(20000);
	            conn.setUseCaches(false);
	            conn.connect();
	            rd  = new BufferedReader( new InputStreamReader(conn.getInputStream(), "UTF-8"));
	            while ((line = rd.readLine()) != null ) {
	                sb.append(line);
	            }
	            response = sb.toString();
	         //   System.out.println(response);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{      
	            try {
	                if(rd != null){
	                    rd.close();
	                }
	                if(conn != null){
	                    conn.disconnect();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return response;
	    }
	
	 //post方法，以from方式提交数据
	 public String post(String url,HashMap<String,String> form){
		 try{
			 conn = (HttpURLConnection) new URL(url).openConnection();
			 //设置请求方式GET POST  HEAD OPTIONS  PUT DELETETRACE 
			 conn.setRequestMethod("POST");
			 conn.setDoOutput(true);
			 conn.setDoInput(true);
			 conn.setReadTimeout(20000);
			 conn.setConnectTimeout(20000);
			 
			 
			 
		 }
		 catch(IOException e){
			 e.printStackTrace();
		 }
		return null;
		 
	 }
	 
	 ///
	 
	  public String post(String url, Map<String, String> form){
	        HttpURLConnection conn = null;
	        PrintWriter pw = null ;
	        BufferedReader rd = null ;
	        StringBuilder out = new StringBuilder();
	        StringBuilder sb = new StringBuilder();
	        String line = null ;
	        String response = null;
	        for (String key : form.keySet()) {
	            if(out.length()!=0){
	                out.append("&");
	            }
	            out.append(key).append("=").append(form.get(key));
	        }
	        try {
	            conn = (HttpURLConnection) new URL(url).openConnection();
	            conn.setRequestMethod("POST");
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            conn.setReadTimeout(20000);
	            conn.setConnectTimeout(20000);
	            conn.setUseCaches(false);
	            conn.connect();
	            //传参数
	            pw = new PrintWriter(conn.getOutputStream());
	            pw.print(out.toString());
	            pw.flush();
	            //读取response的内容
	            rd  = new BufferedReader( new InputStreamReader(conn.getInputStream(), "UTF-8"));
	            while ((line = rd.readLine()) != null ) {
	                sb.append(line);
	            }
	            response = sb.toString();
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{      
	            try {
	                if(pw != null){
	                    pw.close();
	                }
	                if(rd != null){
	                    rd.close();
	                }
	                if(conn != null){
	                    conn.disconnect();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return response;
	    }
	/// //post字符串请求
	    public String postrawBody(String url, String rawBody){
	        HttpURLConnection conn = null;
	        PrintWriter pw = null ;
	        BufferedReader rd = null ;
	        StringBuilder sb = new StringBuilder ();
	        String line = null ;
	        String response = null;
	        try {
	            conn = (HttpURLConnection) new URL(url).openConnection();
	            conn.setRequestMethod("POST");
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            //conn.setReadTimeout(20000);
	           // conn.setConnectTimeout(20000);
	            conn.setRequestProperty("Connection", "Keep-Alive");
	            conn.setUseCaches(false);
	            conn.connect();
	            pw = new PrintWriter(conn.getOutputStream());
	            pw.print(rawBody);
	            pw.flush();
	            
//	            DataOutputStream dos=new DataOutputStream(conn.getOutputStream());
//	            dos.writeBytes(rawBody);
//	            dos.flush();
//	            dos.close();
	            rd  = new BufferedReader( new InputStreamReader(conn.getInputStream(), "UTF-8"));
	            while ((line = rd.readLine()) != null ) {
	                sb.append(line);
	            }
	            response = sb.toString();
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{      
	            try {
	                if(pw != null){
	                    pw.close();
	                }
	                if(rd != null){
	                    rd.close();
	                }
	                if(conn != null){
	                    conn.disconnect();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return response;
	    }
	 
}
