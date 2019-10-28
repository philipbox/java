<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../loginCheck.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보(proview.jsp)</title>
<script type="text/javascript">
	function deleteproduct() {
		var pnum = vform.pnum.value;
		location.href = "productDelete?pnum=" + pnum;
	}
</script>
</head>
<body>
	<h1>상품정보(proview.jsp)</h1>
	<jsp:include page="../menu.jsp"></jsp:include>
	<form action="productUpdate" id="vform">
		<table border="1">
			<tr>
				<td>상품 번호</td>
				<td><input type="text" id="pnum" name="pnum"
					value=${product.pnum } readonly="readonly" /></td>
			</tr>
			<tr>
				<td>상품 이름</td>
				<td><input type="text" id="pname" name="pname"
					value=${product.pname } required="required" /></td>
			</tr>
			<tr>
				<td>상품 가격</td>
				<td><input type="text" id="price" name="price"
					value=${product.price } required="required" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" onclick="deleteproduct()"
					value="상품제거" />&nbsp;&nbsp; <input type="submit" value="상품수정" />
			</tr>
		</table>
	</form>
</body>
</html>