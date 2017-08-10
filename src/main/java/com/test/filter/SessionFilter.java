package com.test.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.test.model.User;


/**
 * Servlet Filter implementation class SessionFilter
 */
public class SessionFilter implements Filter {
	public String[] allowUrls ={"/sucesspojo.do","register.do"};// 登陆，注册，忘记密码不需要拦截  
	  
    public void setAllowUrls(String[] allowUrls) {  
        this.allowUrls = allowUrls;  
    } 
	FilterConfig config;  
    public SessionFilter() {
        super();
    }

	public void destroy() {
		this.config = null;  
	}

	/**
	 * 登录拦截器，如果用户未登录，则统一拦截跳回到登录页面
	 * 其中，一部分用户的请求不做拦截（登录，注册，找回密码等）
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hreq = (HttpServletRequest) request; 
		HttpServletResponse hres = (HttpServletResponse) response;
		
		
		HttpSession session = hreq.getSession();
		hres.setDateHeader("Expires",-1);
		hres.setHeader("Cache-Control","no-cache");
		hres.setHeader("Pragma","no-cache");
		String servletPath = hreq.getServletPath();
		User user = (User)hreq.getSession().getAttribute("loginUser");
		
		//System.out.println("servletPath路径："+servletPath);  
        if (null != allowUrls && allowUrls.length >= 1) {
        	boolean flag = false;
        	for (String url : allowUrls) {  
            	if(servletPath.indexOf(url)>-1){
					flag = true;
					break;
				} 
            }
        	if(flag){
				chain.doFilter(request, response);
			}else{

	        	Object obj = session.getAttribute("loginUser"); 
	        	//System.out.println("obj的值："+obj);
		        if (obj == null || "".equals(obj.toString())) {  
		          hres.sendRedirect(hreq.getContextPath());  
		         
		              
		        } else{
		        	chain.doFilter(request, response);
		        }
			
			}
        }
             
		
		
		  
	}
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig; 
		ServletContext servletContext = fConfig.getServletContext();
		ApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(servletContext);
		//paramService =(ParamService)ctx.getBean("paramService");
	}

}
