<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트(memlist.jsp)</title>
</head>
<body>

	<h1>회원리스트(memlist.jsp)</h1>
	<form action="memreg" method="post">
		<table border="1">
			<tr><th>num</th><th>pw</th><th>name</th><th>tel</th></tr>
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