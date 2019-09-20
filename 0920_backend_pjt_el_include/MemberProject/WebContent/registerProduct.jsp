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
</style>

<script>
	function check(){
		var id = pid.value;
		var name = pname.value;
		var price = pprice.value;
		var count = pcount.value;
		if(id.length < 1 || name.length<1 ){
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
	<h1 align="center">상품 등록</h1>
	
	<form action="product.do?action=product_register" method="post" id="rform">
	<table border="1">
		<tr><td>ID </td><td><input type="text" name="pid" id="pid"></td></tr>
		<tr><td>이름 </td><td><input type="text" name="pname" id="pname"></td></tr>
		<tr><td>가격 </td><td><input type="text" name="pprice" id="pprice"></td></tr>
		<tr><td>재고 </td><td><input type="text" name="pcount" id="pcount"></td></tr>
		<tr><td colspan="2"><input type="button" value="등록" onclick="check()">&nbsp;<input type="reset" value="취소"></td></tr>
	</table>
	</form>
	<!--
	 <a href="index.html">초기화면</a> 
	-->
</body>
</html>