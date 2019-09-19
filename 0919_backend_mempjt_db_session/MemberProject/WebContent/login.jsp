<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

body{
	width : 400px;
	margin : 0 auto;
}

#line{
	width : 300px;
	height : 180px;
	border : 2px solid blue;
}

</style>




</head>
<body>
	<%
		String loginCode = (String) request.getAttribute("loginCode"); 
		if(loginCode != null){
			if(loginCode.equals("1")){
	%>
				<script>
					alert("로그인되었습니다.");
					location.href="main.do?action=listmem";
				</script>
	<% 		
			}
		}
	%>
	<form action="main.do?action=loginmem" method="post">
		<div id="line">
		<h3 align="center">PLEASE LOGIN :-) (jsp)</h3>
		<table style="margin : 10px auto;">
			<tr>
				<td>ID :</td>
				<td><input type="text" name="pid" id="pid"></td>
			</tr>		
			
			<tr>
				<td>PASSWORD :</td>
				<td><input type="password" name="ppw" id="ppw"></td>
			</tr>		
			
			<tr>
				<td colspan="2"><input type="submit" value="로그인"><input type="reset" value="취소"></td>
			</tr>		
			<tr>
				<td><a href="registerMem.html">회원가입</a></td>
			</tr>
		</table>
		</div>
	</form>
</body>
</html>