<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../loginCheck.jsp"></jsp:include>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보(memview.jsp)</title>
<script type="text/javascript">

	function deletemem(){
		var num = rform.num.value;
		location.href="memdelete?num="+num;
	}
	
	
	function updatemem(){
		rform.action="memupdate";
		rform.submit();
	}
	
	window.onload=function(){
		

	}

</script>



</head>
<body>
	<h1>회원정보(memview.jsp)</h1>
	<jsp:include page="../menu.jsp"></jsp:include>
	<form action="#" method="post" id="rform">
		<table border="1">
			<tr><td>num</td><td><input type="text" id="num" name="num" value="${mem.num }" readonly="readonly"/></td></tr>
			<tr><td>pw</td><td><input type="password" id="pw" name="pw" value="${mem.pw }"/></td></tr>
			<tr><td>name</td><td><input type="text" id="name" name="name" value="${mem.name }"/></td></tr>
			<tr><td>tel</td><td><input type="text" id="tel" name="tel" value="${mem.tel }"/></td></tr>
			<tr><td colspan="2"><input type="button" id="delete" onclick="deletemem()" value="삭제"/>&nbsp;&nbsp;<input type="button" id="update" onclick="updatemem()" value="수정"/></td></tr>
		</table>
	</form>
</body>
</html>