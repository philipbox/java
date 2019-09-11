package edu.ssafy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 파라미터 처리
		String name = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String str = new String("");
		//로직터치 
		System.out.println(name + ", " + passwd);
		if(name.equals("ssafy")&&passwd.equals("ssafy")){
			str = "<h2>connected(SSAFY) id : " + name +", passwd :" + passwd+"</h2>";
		}
		else {
			str = "<h2>connected id : " + name +", passwd :" + passwd+"</h2>";
		}
		
		response.getWriter().write(str);
		response.flushBuffer();
	}

}
