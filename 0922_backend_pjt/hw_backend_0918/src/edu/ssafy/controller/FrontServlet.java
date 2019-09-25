package edu.ssafy.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import edu.ssafy.model.MemDBManager;
import edu.ssafy.model.MemManager;
import edu.ssafy.model.MemVo;

public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemDBManager man = new MemDBManager();
//	HttpSession session = null;

//	MemManager man = MemManager.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		//sessoin
		String msg = (String) request.getSession().getAttribute("loginid");
		if(msg == null)
			System.out.println("아직 로그인 안댐");
		else
			System.out.println("로그인된 아이디 : " + msg);
		
		
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		
		System.out.println("action => "+ action);
		if (action.equals("registermem")) {
			registerMem(request, response);
		} else if (action.equals("listmem")) {
			listMem(request, response);
		} else if (action.equals("infomem")) {
			infoMem(request, response);
		} else if (action.equals("updatemem")) {
			updateMem(request, response);
		} else if (action.equals("deletemem")) {
			deleteMem(request, response);
		} else if (action.equals("loginmem")) {
			loginMem(request, response);
		} else if(action.equals("logoutmem")) {
			logoutMem(request, response);
		} 

	}

	private void logoutMem(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; character=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.getSession().invalidate();
		System.out.println("세션종료 후 로그인화면으로");

		
		
		out.println("<script>alert('로그아웃 되었습니다!'); location.href='login.jsp';</script>");
		out.flush();
	}

	private void loginMem(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; character=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("pid");
		String pwd = request.getParameter("ppw");

		System.out.println("접속시도 id : " + id);
		System.out.println("접속시도 pw : " + pwd);
		if (man.isLogin(id, pwd)) {
			request.getSession().setAttribute("loginid", id);
			System.out.println("로그인 성공 세션 id : " + id);
			
			request.setAttribute("loginCode", "1");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			out.println("<script>alert('아이디/패스워드가 잘못되었습니다.'); location.href='login.jsp';</script>");
			out.flush();
		}
	}

	private void deleteMem(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("pid");
		man.memDelete(id);
		// 화면 출력
		
		response.sendRedirect("main.do?action=listmem");
//		listMem(request, response);
	}

	private void updateMem(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 파라미터 처리
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		String name = request.getParameter("pname");
		String tel = request.getParameter("ptel");
		String gender = request.getParameter("pgender");

		man.memUpdate(id, pw, name, tel, gender);
		// 화면 처리
		listMem(request, response);
	}

	private void infoMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("pid");
		MemVo mem = man.memInfo(id);

		if (mem != null) {
			request.setAttribute("mem", mem);
			request.getRequestDispatcher("infoMem.jsp").forward(request, response);
		} else {

		}

	}

	private void listMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<MemVo> list = man.memList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("listMem.jsp").forward(request, response);
	}

	private void registerMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; character=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 파라미터 처리
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		String name = request.getParameter("pname");
		String tel = request.getParameter("ptel");
		String gender = request.getParameter("pgender");

		// 업무처리
		boolean res = man.memInsert(id, pw, name, tel, gender);
		if(res) {
			out.println("<script>location.href='login.jsp';</script>");
		}
		// 필터를 위한 세션Flag
		request.getSession().setAttribute("registerFlag", "yet");
		
		
		out.println("<script>location.href='login.jsp';</script>");
		out.flush();
		
	}

}
