package edu.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.MemVo;
import edu.ssafy.model.ProductDBManager;
import edu.ssafy.model.ProductVo;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDBManager pman = new ProductDBManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		
		if(action.equals("product_manage")) {
			listProduct(request, response);
		}
//		else if(action.equals("product_register")) {
//			registerProduct(request, response);
//		}
	}


	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProductVo> list = pman.productList();
		request.setAttribute("plist", list);
		request.getRequestDispatcher("listProduct.jsp").forward(request, response);
	}

//	private void registerProduct(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; character=UTF-8");
//		PrintWriter out = response.getWriter();
//		
//		
//		// 한글처리
//		request.setCharacterEncoding("utf-8");
//
//		// 파라미터 처리
//		String id = request.getParameter("pid");
//		String name = request.getParameter("pname");
//		int price = Integer.parseInt(request.getParameter("pprice"));
//		int count = Integer.parseInt(request.getParameter("pcount"));
//
//		// 업무처리
//		boolean res = pman.productInsert(id, name, price, count);
//		// 필터를 위한 세션Flag
//		request.getSession().setAttribute("registerFlag", "yet");
//		
//		
//		out.println("<script>location.href='login.jsp';</script>");
//		out.flush();
//		
//	}
	
}
