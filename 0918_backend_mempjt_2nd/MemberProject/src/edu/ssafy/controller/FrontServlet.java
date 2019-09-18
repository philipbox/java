package edu.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import edu.ssafy.model.MemManager;
import edu.ssafy.model.MemVo;

public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemManager man = MemManager.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if(action.equals("registermem")) {
			registerMem(request, response);
		}else if(action.equals("listmem")) {
			listMem(request, response);
		}else if(action.equals("infomem")) {
			infoMem(request, response);
		}else if(action.equals("updatemem")) {
			updateMem(request, response);
		}else if(action.equals("deletemem")) {
			deleteMem(request, response);
		}else if(action.equals("loginmem")) {
			loginMem(request, response);
		}
		
	}

	
	
	
	private void loginMem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; character=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("pid");
		String pwd = request.getParameter("ppw");
		
		System.out.println(id);
		System.out.println(pwd);
		if(man.isLogin(id, pwd)) {
			out.println("<script>alert('login success!'); location.href='login.html';</script></script>");
			out.flush();
		}
		else {
			out.println("<script>alert('login fail'); location.href='#';</script>");
			out.flush();
		}
		
		
	}

	private void deleteMem(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("pid");
		man.memDelete(id);
		//화면 출력 
	}

	private void updateMem(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터 처리
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		String name = request.getParameter("pname");
		String tel = request.getParameter("ptel");
		String gender = request.getParameter("pgender");
		
		man.memUpdate(id, pw, name, tel, gender);
		
		//화면 처리 
		
		
	}

	private void infoMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		MemVo mem = man.memInfo(id);
		
		if(mem != null) {
			request.setAttribute("mem", mem);
			request.getRequestDispatcher("infoMem.jsp").forward(request, response);
		} else {
			
		}
		
	}

	private void listMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemVo> list = man.memList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("listMem.jsp").forward(request, response);
	}
	
	
	private void registerMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
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
				
				// 출력처리
				response.sendRedirect("login.html");

	}

}
