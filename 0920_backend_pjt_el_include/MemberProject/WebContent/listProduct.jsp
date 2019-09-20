<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList, java.util.Arrays,
    edu.ssafy.model.ProductVo"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>

<style type="text/css">
	body{
		width : 350px;
		margin : 0 auto;
	}
	#thId{
		width : 80px;
		text-align : center;
	}
	#thName{
		width : 80px;
		text-align : center;
	}
	#thPrice{
		width : 70px;
		text-align : center;
	}
	#thPrice{
		width : 70px;
		text-align : center;
	}
	td{
	text-align : center;
	}
	
	h5{
		float : right;		
	}
</style>

</head>
<body>

<%
	String getloginid = (String) session.getAttribute("loginid");
	System.out.println("listProduct.jsp의 getloginid: " + getloginid);
	ArrayList<ProductVo> list = (ArrayList<ProductVo>) request.getAttribute("plist");
	for(ProductVo p : list){
		System.out.println(p.toString());
	}
%>
	<h5> 로그인 ID : <%=getloginid%></h5>
	<br>
	<br>
	<br>
		<input type="button" onclick="logout()" id="logpitBtn" value="로그아웃" style="float : right;">
		<br>
		<a href="registerProduct.jsp" style="flaot:right;">상품등록</a>
		
	<h1 align="center">상품 리스트</h1>
	<table border="1">
		<tr><th id="thId">id</th><th id="thName">상품명</th><th id="thPrice">가격</th><th id="thCount">재고</th></tr>
		<%for(int i=0; i<list.size(); i++){ %>
		<tr>
			<td><%=list.get(i).getId()%></td>
			<td><a href="main.do?action=infomem&pid=<%=list.get(i).getId()%>"><%=list.get(i).getName()%></a></td>
			<td><%=list.get(i).getPrice()%></td>
			<td><%=list.get(i).getCount()%></td>
		</tr>
		<%}%>
	</table>


</body>
</html>