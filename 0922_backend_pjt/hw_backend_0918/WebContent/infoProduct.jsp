<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="edu.ssafy.model.ProductVo"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>

<style type="text/css">
body{
	width : 350px;
	margin : 0 auto;
}
td{
	text-align : center;
}
</style>

<script type="text/javascript">

function updateProduct(){
	rform.action="product.do?action=product_update";
	alert("수정되었습니다.");
	rform.submit();
}


function deleteProduct(){
	var id = pid.value;
	alert("삭제되었습니다.");
	location.href="product.do?action=product_delete&pid="+id;
}
</script>


</head>
<body>
<%
	String getloginid = (String) session.getAttribute("loginid");
%>
	<% ProductVo product = (ProductVo) request.getAttribute("plist"); %>
	<jsp:include page="/menu/productbar2.jsp"></jsp:include>
	<h1 align="center">상품 정보</h1>
	<h5 style="text-align: center;">로그인 ID :<label style="color:blue;"> <%=getloginid%></label></h5>
	<form action="main.do" method="post" id="rform">
	<table border="1">
		<tr><th style="width:80px;">ID </th><td><input type="text" name="pid" id="pid" readonly value=<%=product.getId()%>></td></tr>
		<tr><th>상품명</th><td><input type="text" name="pname" value=<%=product.getName()%>></td></tr>
		<tr><th>가격</th><td><input type="text" name="pprice" value=<%=product.getPrice()%>></td></tr>
		<tr><th>재고</th><td><input type="text" name="pcount" value=<%=product.getCount()%>></td></tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="updateProduct()" style="width:60px">&nbsp;
				<input type="button" value="삭제" onclick="deleteProduct()" style="width:60px">&nbsp;
			
			</td></tr>
	</table>
	</form>
</body>
</html>