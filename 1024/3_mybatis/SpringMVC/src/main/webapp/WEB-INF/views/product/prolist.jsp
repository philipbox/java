<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../loginCheck.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록(prolist.jsp)</title>

<script type="text/javascript">
	function goProductRegPage(){
		location.href="productRegPage";
	}
	window.onload=function(){
		

	}
</script>
</head>
<body>
	<h1>상품목록(prolist.jsp)</h1>
<jsp:include page="../menu.jsp"></jsp:include>
	<table border="1">
		<tr>
			<th>상품 번호</th>
			<th>상품 이름</th>
			<th>상품 가격</th>
		</tr>
		<c:forEach items="${productList }" var="plist">
			<tr>
				<td><a href="productView?pnum=${plist.pnum }">${plist.pnum }</a></td>
				<td>${plist.pname }</td>
				<td>${plist.price }</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" onclick="goProductRegPage()" value="상품추가"/>
</body>
</html>