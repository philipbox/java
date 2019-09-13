package edu.ssafy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.sendRedirect("Result.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String num3 = request.getParameter("num3");
		
		String title = request.getParameter("title");
		
		String cate = request.getParameter("book_cate");
		String from = request.getParameter("chk_info");
		String date = request.getParameter("date");
		String publisher = request.getParameter("publisher");
		
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String contents = request.getParameter("contents");
		
		String str = "<style type=\"text/css\">\r\n" + 
				"td{\r\n" + 
				"	border : 1px solid #BDBDBD;\r\n" + 
				"	height : 30px;\r\n" + 
				"}\r\n" + 
				"</style><div style=\"margin : auto; width:500px; height:540px;\">\r\n" + 
				"		<div>\r\n" + 
				"			<h2 style=\"text-align : center;\">도서 등록 화면 </h2>\r\n" + 
				"		</div>\r\n" + 
				"		<div id=\"contents\">\r\n" + 
				"			<table style=\"margin: auto; border : 1px solid #BDBDBD\">\r\n" + 
				"				<tr>\r\n" + 
				"					<td style=\"width : 100px;\">도서명</td>\r\n" + 
				"					<td style=\"width : 400px;\">"+title+"</td>\r\n" + 
				"				</tr>\r\n" + 
				"				<tr>\r\n" + 
				"					<td>도서번호</td>\r\n" + 
				"					<td>"+num1+"-"+num2+"-"+num3+"</td>\r\n" + 
				"				</tr>\r\n" + 
				"				<tr>\r\n" + 
				"					<td>도서분류</td>\r\n" + 
				"					<td>"+cate+"</td>\r\n" + 
				"				</tr>\r\n" + 
				"				<tr>\r\n" + 
				"					<td>도서국가</td>\r\n" + 
				"					<td>"+from+"</td>\r\n" + 
				"				</tr>\r\n" + 
				"				<tr>\r\n" + 
				"					<td>출판일</td>\r\n" + 
				"					<td>"+date+"</td>\r\n" + 
				"				</tr>				\r\n" + 
				"				<tr>\r\n" + 
				"					<td>출판사</td>\r\n" + 
				"					<td>"+publisher+"</td>\r\n" + 
				"				</tr>\r\n" + 
				"				<tr>\r\n" + 
				"					<td>저 자</td>\r\n" + 
				"					<td>"+author+"</td>\r\n" + 
				"				</tr>\r\n" + 
				"				<tr>\r\n" + 
				"					<td>도서가격</td>\r\n" + 
				"					<td>"+price+"</td>\r\n" + 
				"				</tr>\r\n" + 
				"				<tr>\r\n" + 
				"					<td>도서설명</td>\r\n" + 
				"					<td>"+contents+"</td>\r\n" + 
				"				</tr>\r\n" + 
				"			</table>\r\n" + 
				"		</div>\r\n" + 
				"	</div>";
		
		response.getWriter().write(str);
		response.flushBuffer();
	}
}
