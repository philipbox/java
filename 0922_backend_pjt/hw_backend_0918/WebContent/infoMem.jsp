<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="edu.ssafy.model.MemVo"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>

<style type="text/css">
body{
	width : 300px;
	margin : 0 auto;
}
td{
	text-align : center;
}
</style>

<script type="text/javascript">

function updateMem(){
	rform.action="main.do?action=updatemem";
	alert("수정되었습니다.");
	rform.submit();
}


function deleteMem(){
	var id = pid.value;
	alert("삭제되었습니다.");
	location.href="main.do?action=deletemem&pid="+id;
}
</script>

</head>
<body>
<%
	String getloginid = (String) session.getAttribute("loginid");
%>
	<% MemVo mem = (MemVo) request.getAttribute("mem"); %>

	<jsp:include page="/menu/membar.jsp"></jsp:include>
	<h1 align="center">회원 정보</h1>
	<h5 style="text-align: center;">로그인 ID :<label style="color:blue;"> <%=getloginid%></label></h5><br>
	
	<form action="main.do" method="post" id="rform">
	<table border="1">
		<tr><td style="width:80px">ID </td><td><input type="text" name="pid" id="pid" readonly value=<%=mem.getId()%>></td></tr>
		<tr><td>PW </td><td><input type="text" name="ppw" value=<%=mem.getPw()%>></td></tr>
		<tr><td>이름 </td><td><input type="text" name="pname" value=<%=mem.getName()%>></td></tr>
		<tr><td>전화번호 </td><td><input type="tel" name="ptel" value=<%=mem.getTel()%>></td></tr>
		<tr><td>성별 </td>
		
		<td>
		<label for="man">남</label>
		<%if(mem.getGender().equals("남")){ %>
			<input type="radio" id="man" name="pgender" value="남" checked="checked">
		<%} else{%>
			<input type="radio" id="man" name="pgender" value="남">
		<%} %>
		
		<label for="woman">여</label>
		<%if(mem.getGender().equals("여")){ %>
			<input type="radio" id="woman" name="pgender" value="여" checked="checked">
		<%} else{%>
			<input type="radio" id="woman" name="pgender" value="여">
		<%} %>		
		</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="updateMem()" style="width:60px">&nbsp;
				<input type="button" value="삭제" onclick="deleteMem()" style="width:60px">&nbsp;
			
			</td></tr>
	</table>
	</form>
</body>
</html>