package edu.ssafy.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//전
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String action = req.getParameter("action");
		String id = (String) req.getSession().getAttribute("loginid");
		String regFlag = "";
		System.out.println("플래그 : " + req.getSession().getAttribute("registerFlag"));
		if(req.getSession().getAttribute("registerFlag")!=null) {
			regFlag = (String) req.getSession().getAttribute("registerFlag");
		}
		
		
		if(id==null) {
			if(action.equals("listmem") || action.equals("infomem") || action.equals("updatemem") || action.equals("deletemem") ) {
				System.out.println("id도 없는게 까불어");
				res.sendRedirect("login.jsp");
				return;
			}
			
			// 정상적으로 회원가입 경로를 들어왔으면 registerer일텐데, 그게 아니면 비정상적인 경로라는 것. 
			else if(action.equals("registermem") && !regFlag.equals("registered")) {
				System.out.println("회원가입하는척 하지마라");
				res.sendRedirect("login.jsp");
				return;
			}
		}
		
		chain.doFilter(request, response);
		//후
		
		
	}

 	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
