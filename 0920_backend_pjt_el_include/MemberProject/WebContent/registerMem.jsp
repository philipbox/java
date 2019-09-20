<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
<style type="text/css">

body{
	width: 300px;
	margin: 0 auto;
}
</style>

<script>
	function check(){
		var id = pid.value;
		if(id.length < 3){
			alert("ID가 너무 짧습니다.");
			pid.focus();
			return;
		}
		rform.submit();
	}

</script>

</head>
<body>
<%
	// 정상적으로 등록페이지에 들어왔을 때, 필터를위한Flag 세션을 registered로 초기화.
	request.getSession().setAttribute("registerFlag", "registered");
%>
	<h1 align="center">회원 등록</h1>
	
	<form action="main.do?action=registermem" method="post" id="rform">
	<table border="1">
		<tr><td>ID </td><td><input type="text" name="pid" id="pid"></td></tr>
		<tr><td>PW </td><td><input type="password" name="ppw"></td></tr>
		<tr><td>이름 </td><td><input type="text" name="pname"></td></tr>
		<tr><td>전화번호 </td><td><input type="tel" name="ptel"></td></tr>
		<tr><td>성별 </td><td><label for="man">남</label><input type="radio" id="man" name="pgender" value="남"><label for="woman">여</label><input type="radio" id="woman" name="pgender" value="여"></td></tr>
		<tr><td colspan="2"><input type="button" value="등록" onclick="check()">&nbsp;<input type="reset" value="취소"></td></tr>
	</table>
	</form>
	<!--
	 <a href="index.html">초기화면</a> 
	-->
</body>
</html>