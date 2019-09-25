<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList, java.util.Arrays,
    edu.ssafy.model.ProductVo"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>

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
	#thPrice{
		width : 70px;
		text-align : center;
	}
	#thPrice{
		width : 70px;
		text-align : center;
	}
	td{
		text-align : center;
	}
</style>

</head>
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">

$(function() {
    $(".hover").hover(function() {
        var id = this.id;
        $.ajax({
            url : "product.do?action=product_ajax",
            type : "get",
            data : {
                pid: id,
            },
            dataType : "html",
            success : function(data) {
                $("#receive").html(data);
            }
        });
        console.log($(this).text());
    })
})


</script>
<body>

<%
	String getloginid = (String) session.getAttribute("loginid");
	ArrayList<ProductVo> list = (ArrayList<ProductVo>) request.getAttribute("plist");
%>
	<jsp:include page="/menu/productbar.jsp"></jsp:include>
	<h1 align="center">상품 목록</h1>
	<h5 style="text-align: center;">로그인 ID :<label style="color:blue;"> <%=getloginid%></label></h5>
	<table border="1">
		<tr><th id="thId" >id</th><th id="thName">상품명</th><th id="thPrice">가격</th><th id="thCount">재고</th></tr>
		<%for(int i=0; i<list.size(); i++){ %>
		<tr>
			<td class="hover" id="<%=list.get(i).getId()%>"><%=list.get(i).getId()%></td>
			<td><a href="product.do?action=product_info&pid=<%=list.get(i).getId()%>"><%=list.get(i).getName()%></a></td>
			<td><%=list.get(i).getPrice()%></td>
			<td><%=list.get(i).getCount()%></td>
		</tr>
		<%}%>
	</table>

	<div id=receive></div>

</body>
</html>