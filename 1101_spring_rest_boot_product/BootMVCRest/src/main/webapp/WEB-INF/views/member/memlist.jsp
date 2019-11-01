<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <!-- <jsp:include page="../loginCheck.jsp"></jsp:include> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트(memlist.jsp)</title>
</head>
<body>
	<h1>회원리스트</h1>
	<jsp:include page="../menu.jsp"></jsp:include>
	<br>
	<form action="memreg" method="post">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>전화번호</th>
			</tr>
			<c:forEach items="${mems }" var="mem">
				<tr>
					<td><a href="memview?num=${mem.num}">${mem.num}</a></td>
					<td>${mem.pw}</td>
					<td>${mem.name}</td>
					<td>${mem.tel}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>