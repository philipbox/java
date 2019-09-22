<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>

<style type="text/css">

body{
	width: 300px;
	margin: 0 auto;
}
td{
	text-align : center;
}

form{
	width : 300px;
}
</style>

<script>
	function check(){
		var id = pid.value;
		var name = pname.value;
		var price = pprice.value;
		var count = pcount.value;
		if(id.length < 1 || name.length<1 || price.length <1 || count.length <1){
			alert("모두 입력해주세용.");
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
	//request.getSession().setAttribute("registerFlag", "registered");
%>
<%
	String getloginid = (String) session.getAttribute("loginid");
%>
	<jsp:include page="/menu/productbar2.jsp"></jsp:include>
	<h1 align="center">상품 등록</h1>
	<h5 style="text-align: center;">로그인 ID :<label style="color:blue;"> <%=getloginid%></label></h5>
	
	<form action="product.do?action=product_register" method="post" id="rform">
	<table border="1">
		<tr><td style="width:80px;">ID </td><td><input type="text" name="pid" id="pid"></td></tr>
		<tr><th>이름 </th><td><input type="text" name="pname" id="pname"></td></tr>
		<tr><th>가격 </th><td><input type="text" name="pprice" id="pprice"></td></tr>
		<tr><th>재고 </th><td><input type="text" name="pcount" id="pcount"></td></tr>
		<tr><td colspan="2"><input type="button" value="등록" onclick="check()" style="width:60px;">&nbsp;<input type="reset" value="취소" style="width:60px;"></td></tr>
	</table>
	</form>
	<!--
	 <a href="index.html">초기화면</a> 
	-->
</body>
</html>