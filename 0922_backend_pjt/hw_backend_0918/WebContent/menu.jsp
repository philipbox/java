<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Menu Example</title>
<style type="text/css">
nav{
	width : 270px;
	margin : 0px auto;
}
ul{
	list-style: none;
	margin: 0; padding: 0;
}
ul > li{
	float: left;
	display: block;
}
ul:after{
	content : '';
	clear : both;
	display : block;
}
ul  li  a{
	padding : 5px 15px;
	text-decoration: none;
	background: #1e7c9a;
	color : #fff;
	display: block;
}
ul  li  a:hover{
	background : #3b3b3b;
}
ul  ul{
	display : none;
}
ul li:hover ul{
	display : block;
	position : absolute;
}
li:hover li{
	float : none;
}
</style>

<script type="text/javascript">

function goList(){
	location.href="main.do?action=listmem";
}

function goProduct(){
	location.href="product.do?action=product_list";
}

</script>
<body>
<%
	String getloginid = (String) session.getAttribute("loginid");
%>
	<br>
	<H1 style="text-align: center;">로그인 되었습니다.</H1>
	<h5 style="text-align: center;">로그인 ID :<label style="color:blue;"> <%=getloginid%></label></h5><br>
	<h3 style="text-align: center;">메뉴를 선택해주세요.</h3>
	<jsp:include page="/menu/menubar.jsp"></jsp:include>
<!-- 
	<nav>
		<ul>
			<li><a href="main.do?action=listmem">회원 관리</a></li>
			<li><a href="product.do?action=product_list">상품 관리</a></li>
			<li><a href="main.do?action=logoutmem">로그아웃</a>
		</ul>
	</nav>
 -->	
</body>
</html>