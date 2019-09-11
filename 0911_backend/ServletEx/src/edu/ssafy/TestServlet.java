package edu.ssafy;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int cnt;

	/*
	 * 처음 한번만 실행되는 것.(서블렛이 처음올라올때 처리되는 것)
	 */
	@Override 
	public void init(ServletConfig config) throws ServletException {
		// 위의 init이 뭐하는지 모르잖아. 오버라이드하니까 상위의 init실행
		super.init(config);
		cnt++;
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		super.service(req, res);
		cnt++;
		System.out.println("cnt : " + cnt);
	}
	
	public void destroy() {
		super.destroy();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet.....");
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("end");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost.....");
		doGet(request, response);
	}

}
