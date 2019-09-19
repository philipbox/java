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
		width : 350px;
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
	
	h5{
		float : right;		
	}
</style>

<script type="text/javascript">
function logout(){
	alert("세션삭제할꾸양! ");
	location.href="main.do?action=logoutmem";
}

</script>
</head>
<body>
<%
	String getloginid = (String) session.getAttribute("loginid");
	System.out.println("listMem.jsp의 getloginid: " + getloginid);
	ArrayList<MemVo> list = (ArrayList<MemVo>) request.getAttribute("list");
%>
	<h5> 로그인 ID : <%=getloginid%></h5>
	<br>
	<br>
	<br>
		<input type="button" onclick="logout()" id="logpitBtn" value="로그아웃" style="float : right;">
	<h1 align="center">회원 리스트</h1>
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