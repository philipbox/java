<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록(memreg.jsp)</title>
</head>
<body>
	<h1>회원등록(memreg.jsp)</h1>
	<form action="memreg" method="post">
		<table border="1">
			<tr><td>num</td><td><input type="text" id="num" name="num" required="required"/></td></tr>
			<tr><td>pw</td><td><input type="password" id="pw" name="pw" required="required"/></td></tr>
			<tr><td>name</td><td><input type="text" id="name" name="name"/></td></tr>
			<tr><td>tel</td><td><input type="text" id="tel" name="tel"/></td></tr>
			<tr><td colspan="2"><input type="reset" value="취소"/>&nbsp;&nbsp;<input type="submit" value="전송"/></tr>
		</table>
	</form>
</body>
</html>