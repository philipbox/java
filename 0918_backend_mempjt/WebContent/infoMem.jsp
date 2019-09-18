<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="edu.ssafy.model.MemVo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<script type="text/javascript">
function updateMem(){
	rform.action="main.do?action=updatemem";
	rform.submit();
}
function deleteMem(){
	var id = pid.value;
	location.href="main.do?action=deletemem&pid="+id;
}	
</script>
</head>
<body>
	<% MemVo mem = (MemVo)request.getAttribute("mem"); %>
	<h1 align="center">회원 정보</h1>
	<form action="main.do" method="post" id="rform">
		<table border="1">
			<tr>
				<td>ID :</td>
				<td><input type="text" name="pid" id="pid" value=<%=mem.getId() %>></td>
			</tr>
			<tr>
				<td>PW :</td>
				<td><input type="password" name="ppw"  value=<%=mem.getPw() %>></td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td><input type="text" name="pname"  value=<%=mem.getName() %>></td>
			</tr>
			<tr>
				<td>전화번호 :</td>
				<td><input type="tel" name="ptel"  value=<%=mem.getTel() %>></td>
			</tr>
			<tr>
				<td>성별 :</td>
				
				<td>
					<label for="man">남</label>
					<%if(mem.getGender().equals("남")){ %>
						<input type="radio" id="man" name="pgender" value="남" checked="checked">
					<%}else { %>
						<input type="radio" id="man" name="pgender" value="남" checked="checked">
					<%} %>
					
					<label for="woman">여</label>
					
					<%if(mem.getGender().equals("남")){ %>
						<input type="radio" name="pgender" value="여" id="woman" checked="checked">
					<%}else { %>
						<input type="radio" name="pgender" value="여" id="woman">
					<%} %>
				
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onclick="updateMem()">
					<input type="button" value="삭제" onclick="deleteMem()">
				</td>
			</tr>
		</table>
	</form>
	<a href="index.html">초기화면</a>
</body>
</html>