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
		width : 300px;
		margin : 0 auto;
	}
	#thId{
		width : 80px;
		text-align : center;
	}
	#thName{
		width : 80px;
		text-align : center;
	}
	#thGender{
		width : 50px;
		text-align : center;
		
	}
	td{
		text-align : center;
	}
</style>
</head>
<body>
<%
	String getloginid = (String) session.getAttribute("loginid");
	System.out.println("listMem.jsp의 getloginid: " + getloginid);
	ArrayList<MemVo> list = (ArrayList<MemVo>) request.getAttribute("list");
%>
	<jsp:include page="/menu/membar.jsp"></jsp:include>
	<h1 align="center">회원 리스트</h1>
	<h5 style="text-align: center;">로그인 ID :<label style="color:blue;"> <%=getloginid%></label></h5><br>
	<table border="1">
		<tr><th id="thId">id</th><th id="thName">이름</th><th id="thGender">성별</th></tr>
		<%for(int i=0; i<list.size(); i++){ %>
		<tr><td><%=list.get(i).getId()%></td><td><a href="main.do?action=infomem&pid=<%=list.get(i).getId()%>"><%=list.get(i).getName()%></a></td><td><%=list.get(i).getGender()%></td></tr>
		<%}%>
	</table>
	<!-- 
		<a href="index.html">홈으로</a>
	-->
</body>
</html>