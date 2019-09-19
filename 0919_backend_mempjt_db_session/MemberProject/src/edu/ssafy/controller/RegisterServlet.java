package edu.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.MemManager;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemManager man = MemManager.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		if(res) {
			request.setAttribute("res", "회원등록이 성공하였습니다.");
		}
		else {
			request.setAttribute("res", "회원등록이 실패하였습니다.");
		}
		request.getRequestDispatcher("result.jsp").forward(request, response);

	}

}
