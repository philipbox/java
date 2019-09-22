<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

body{
	width : 300px;
	margin : 0 auto;
}
td{
	text-align : center;
}

#line{
	margin-top : 100px;
	width : 300px;
	height : 180px;
	border : 2px solid blue;
}

</style>

<script type="text/javascript">

function login(){
	var id = pid.value;
	var pw = ppw.value;
	if(id.length < 1 || pw.length<1){
		alert("ID와 PW를 모두 입력해주세요.");
		return;
	}
	else {
		rform.submit();
	}	
}

</script>


</head>
<body>
	<%
		String loginCode = (String) request.getAttribute("loginCode"); 
		if(loginCode != null){
			if(loginCode.equals("1")){
	%>
				<script>
					alert("로그인되었습니다.");
					location.href="menu.jsp";
				</script>
	<% 		
			}
		}
	%>
	<form action="main.do?action=loginmem" method="post" id="rform">
		<div id="line">
		<h3 align="center">PLEASE LOGIN :-)</h3>
		<table style="margin : 10px auto;">
			<tr>
				<td>ID </td>
				<td><input type="text" name="pid" id="pid"></td>
			</tr>		
			
			<tr>
				<td>PASSWORD </td>
				<td><input type="password" name="ppw" id="ppw"></td>
			</tr>		
			
			<tr>
				
				<td colspan="2"><input hidden="hidden"/><input type="button" onClick="login();" value="로그인" style="width : 60px"><input type="reset" value="취소" style="width : 60px;"></td>
			</tr>		
			<tr>
				<td><a href="registerMem.jsp">회원가입</a></td>
			</tr>
		</table>
		</div>
	</form>
</body>
</html>