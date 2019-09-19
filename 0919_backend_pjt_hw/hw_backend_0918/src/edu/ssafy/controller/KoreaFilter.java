package edu.ssafy.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class KoreaFilter
 */
//@WebFilter(filterName="koreafilter",urlPatterns="*do",
//			initParams=@WebInitParam(name="kor", value="utf-8"))
public class KoreaFilter implements Filter {

	String charset;
	public void init(FilterConfig fConfig) throws ServletException {
		charset = fConfig.getInitParameter("kor");
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//전처리 
		request.setCharacterEncoding(charset);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		// 후처리
		
	}


}
