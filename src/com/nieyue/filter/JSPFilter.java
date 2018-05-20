package com.nieyue.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** JSP过滤器 */
public class JSPFilter implements Filter {

	
	/** 初始化方法 */
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/** 过滤处理方法 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		 // 获得在下面代码中要用的request,response
		         HttpServletRequest servletRequest = (HttpServletRequest) request;
		         HttpServletResponse servletResponse = (HttpServletResponse) response;
		 // 获得用户请求的URI
		 //String path = servletRequest.getRequestURI(); 
		         String path=servletRequest.getServletPath();
		  if (path.indexOf(".jsp")>-1||path.indexOf(".php")>-1||path.indexOf(".asp")>-1){
			//对请求过滤
			 servletRequest.getRequestDispatcher(servletRequest.getContextPath()+"/404.html").forward(request, response);
			  //servletResponse.sendRedirect(servletRequest.getContextPath()+"/404.html");
		}else{
			//*.html;*.js;*.css;*.jpg;*.png;*.eot;*.svg;*.ttf;*.woff;*.woff2
			if(path.indexOf(".html")>0
					||path.indexOf(".js")>0
					||path.indexOf(".css")>0
					||path.indexOf(".jpg")>0
					||path.indexOf(".png")>0
					||path.indexOf(".eot")>0
					||path.indexOf(".svg")>0
					||path.indexOf(".ttf")>0
					||path.indexOf(".woff")>0
					||path.indexOf(".woff2")>0
					)
			{
				servletRequest.getRequestDispatcher(path).forward(request, response);
				//servletResponse.sendRedirect(path);
				return;
				
			}
			chain.doFilter(request,response);
			
		}
	}

	/** 销毁方法 */
	public void destroy() {
		
	}

}