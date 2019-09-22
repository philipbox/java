<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

function goList(){
	location.href="main.do?action=listmem";
}

function goProduct(){
	location.href="product.do?action=product_list";
}


</script>

</head>
<body>
	<input type="button" onclick="goList()" value="회원 리스트"/>
	<input type="button" onclick="goProduct()" value="상품 관리"/>
</body>
</html>