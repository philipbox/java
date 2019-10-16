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
		
		if(action.equals("product_list")) {
			listProduct(request, response);
		}
		else if(action.equals("product_register")) {
			registerProduct(request, response);
		}
		else if(action.equals("product_info")) {
			infoProduct(request, response);
		}
		else if(action.equals("product_update")) {
			updateProduct(request,response);
		}
		else if(action.equals("product_delete")) {
			deleteProduct(request,response);
		}
		else if(action.equals("product_ajax")) {
			displayInfo(request,response);
		}
		
	}


	private void displayInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		ProductVo plist = pman.productInfo(id);

		if (plist != null) {
			request.setAttribute("plist", plist);
			request.getRequestDispatcher("ajax.jsp").forward(request, response);
		} else {
			
		}
		
	}


	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("pid");
		pman.productDelete(id);
		// 화면 출력
		
		response.sendRedirect("product.do?action=product_list");
//		listMem(request, response);		
	}


	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 파라미터 처리
		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		String price = request.getParameter("pprice");
		String count = request.getParameter("pcount");

		pman.productUpdate(id, name, price, count);
		// 화면 처리
		response.sendRedirect("product.do?action=product_list");
	}


	private void infoProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		ProductVo plist = pman.productInfo(id);

		if (plist != null) {
			request.setAttribute("plist", plist);
			request.getRequestDispatcher("infoProduct.jsp").forward(request, response);
		} else {
			
		}

		
		
		
	}


	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProductVo> list = pman.productList();
		request.setAttribute("plist", list);
		request.getRequestDispatcher("listProduct.jsp").forward(request, response);
	}

	private void registerProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; character=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 파라미터 처리
		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		int price = Integer.parseInt(request.getParameter("pprice"));
		int count = Integer.parseInt(request.getParameter("pcount"));

		// 업무처리
		boolean res = pman.productInsert(id, name, price, count);
		// 필터를 위한 세션Flag
		
		if(res) {
			System.out.println("등록된 상품 내역 : " + id +" " + name + " " + price + " " + count);
		} else {
			System.out.println("제대로 입력해 쨔샤 ");
		}
		
		request.getSession().setAttribute("registerFlag", "yet");
		
		
		out.println("<script>location.href='login.jsp';</script>");
		out.flush();
		
	}
	
}
