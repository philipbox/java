package edu.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.dao.MemDBManager;


/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/main.do")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemDBManager man = new MemDBManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		
		System.out.println("action => "+ action);
		
		if(action.equals("register_mem")) {
			memRegister(request,response);
		}
		else if(action.equals("login_mem")) {
			memLogin(request, response);
		}

	}

	private void memLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; character=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("login_id");
		String pwd = request.getParameter("login_pw");

		System.out.println("접속시도 id : " + id);
		System.out.println("접속시도 pw : " + pwd);
		if (man.isLogin(id, pwd)) {
			request.getSession().setAttribute("loginid", id);
			System.out.println("로그인 성공 세션 id : " + id);
			
			request.setAttribute("loginCode", "1");
			request.getRequestDispatcher("index.html").forward(request, response);
		} else {
			out.println("<script>alert('아이디/패스워드가 잘못되었습니다.'); location.href='index.html';</script>");
			out.flush();
		}
	}

	private void memRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; character=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 파라미터 처리
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String address = request.getParameter("addr");
		String phone = request.getParameter("tel");
		String[] allergyArr = request.getParameterValues("allergy");
		String allergy = "";
		
		if(allergyArr != null) {
			for(String s : allergyArr)
				allergy = allergy + ","+s;
		}
		else {
			allergy="N/A";
		}
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(address);
		System.out.println(phone);
		System.out.println(allergy);
		
		// 업무처리
		if(man.memInsert(id, pw, name, address, phone, allergy)) {
			// 필터를 위한 세션Flag
//			request.getSession().setAttribute("registerFlag", "yet");
		}
		
		out.println("<script>location.href='index.html';</script>");
		out.flush();
	}

}
