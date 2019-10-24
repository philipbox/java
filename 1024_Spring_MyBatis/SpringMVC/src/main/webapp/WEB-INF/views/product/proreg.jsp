<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../loginCheck.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록(proreg.jsp)</title>
</head>
<body>
	<h1>상품등록(proreg.jsp)</h1>
	<jsp:include page="../menu.jsp"></jsp:include>
	<form action="productRegister" method="post">
		<table border="1">
			<tr>
				<td>상품 번호</td>
				<td><input type="text" id="pnum" name="pnum"
					required="required" /></td>
			</tr>
			<tr>
				<td>상품 이름</td>
				<td><input type="text" id="pname" name="pname"
					required="required" /></td>
			</tr>
			<tr>
				<td>상품 가격</td>
				<td><input type="text" id="price" name="price"
					required="required" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="취소" />&nbsp;&nbsp;
					<input type="submit" value="상품추가" />
			</tr>
		</table>
	</form>
</body>
</html>