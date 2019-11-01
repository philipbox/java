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
	
	function gofileuploadPage(){
		location.href="fileuploadpage";
	}
	
</script>
</head>
<body>
	<H1>Hello! Welcome To SSAFY !</H1>
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
					&nbsp;&nbsp; <input type="button" onclick="goMemRegPage()" value="회원가입">
					&nbsp;&nbsp; <input type="button" onclick="gofileuploadPage()" value="파일업로드"></td>
			</tr>
		</table>
	</form>
	
	<div style="background-color:#848484; width:300px;">
	<h4>[개발용 화면 div] - 바로가기</h4>
		<a href="memregpage">회원등록</a>
		<br>
		<a href="proList">상품목록</a>
		<br>
		<a href="fileuploadpage">파일업로드</a>
	</div>
</body>
</html>