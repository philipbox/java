<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goMemRegPage(){
		location.href="memregpage";
	}
</script>
</head>
<body>
	<H1>Hello index.jsp</H1>
	<h3>로그인</h3>
	<form action="memlogin">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" id="loginID" name="loginID"
					required="required"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="loginPW" name="loginPW"
					required="required"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인">
					&nbsp;&nbsp; <input type="button" onclick="goMemRegPage()" value="회원가입"></td>
			</tr>
		</table>
	</form>
	<a href="memregpage">회원등록</a>
	<br>
	<a href="proList">상품목록</a>
</body>
</html>