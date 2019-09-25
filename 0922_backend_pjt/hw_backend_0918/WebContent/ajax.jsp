<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="edu.ssafy.model.ProductVo"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% ProductVo product = (ProductVo) request.getAttribute("plist"); %>
	<h1 align="center">상품 정보</h1>
	<table border="1">
		<tr><th style="width:80px;">ID </th><td><input type="text" name="pid" id="pid" readonly value=<%=product.getId()%>></td></tr>
		<tr><th>상품명</th><td><input type="text" name="pname" value=<%=product.getName()%>></td></tr>
		<tr><th>가격</th><td><input type="text" name="pprice" value=<%=product.getPrice()%>></td></tr>
		<tr><th>재고</th><td><input type="text" name="pcount" value=<%=product.getCount()%>></td></tr>
	</table>
	
	

</body>
</html>