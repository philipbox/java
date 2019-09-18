<%@ 
	page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"
    import="java.util.ArrayList, edu.ssafy.model.MemVo"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
<style type="text/css">
	body{
		width : 500px;
		margin : 0 auto;
	}
</style>

</head>
<body>
<%
	ArrayList<MemVo> list = (ArrayList<MemVo>) request.getAttribute("list");
	System.out.println(list.toString());
%>
	<h1>회원 리스트</h1>
	<table border="1">
		<tr><th>id</th><th>이름</th><th>성별</th></tr>
		<%for(int i=0; i<list.size(); i++){ %>
		<tr><td><%=list.get(i).getId()%></td><td><a href="main.do?action=infomem&pid=<%=list.get(i).getId()%>"><%=list.get(i).getName()%></a></td><td><%=list.get(i).getGender()%></td></tr>
		<%}%>
	</table>
		<a href="index.html">홈으로</a>
</body>
</html>