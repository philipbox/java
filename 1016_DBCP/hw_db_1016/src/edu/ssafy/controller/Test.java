package edu.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.Product;
import edu.ssafy.model.ProductDAO;

/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static ProductDAO pman = new ProductDAO();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		ArrayList<Product> pList = new ArrayList<Product>();
		pList = pman.ListProduct();
		PrintWriter writer = response.getWriter();
		writer.write("----- 상품목록 -----<br/>");
		for(Product p : pList) {
		writer.write("ID: " + p.getId() + " / " + "상품명: " + p.getName() +" / " + " 가격: " + p.getPrice() +"<br/>");
		}
		
		
		
		
		
		
		
		writer.flush();
	}

}
