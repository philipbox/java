package edu.ssafy.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.MemManager;
import edu.ssafy.model.MemVo;

@WebServlet("/main.do")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemManager man = MemManager.getInstance(); 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if (action.equals("registermem")) {
			registerMem(request, response);
		}else if(action.equals("listmem")) {
			listMem(request,response);
		}else if(action.equals("infomem")) {
			infoMem(request,response);
		}
		
	}

	private void infoMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		MemVo mem = man.memInfo(id);
		if(mem != null) {
			request.setAttribute("mem", mem);
			request.getRequestDispatcher("infoMem.jsp").forward(request, response);
		}else {
			
		}
		
	}

	private void listMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemVo> list = man.memList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("listMem.jsp").forward(request, response);
	}

	private void registerMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 처리
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		String name = request.getParameter("pname");
		String tel = request.getParameter("ptel");
		String gender = request.getParameter("pgender");
		// 업무처리
		boolean res = man.memInsert(id, pw, name, tel, gender);
		// 출력처리
		String str = new String(); 
		if (res) {
			//request.setAttribute("res", "등록 되었습니다");
			str = " 등록되었습니다";

		} else {
			//request.setAttribute("res", "등록 실패 하였습니다");
			str="등록실패하였습니다";
		}
		//request.getRequestDispatcher("result.jsp").forward(request, response);
		String encode = URLEncoder.encode(str, "utf-8");
		response.sendRedirect("result.jsp?res="+encode);
	}

}
