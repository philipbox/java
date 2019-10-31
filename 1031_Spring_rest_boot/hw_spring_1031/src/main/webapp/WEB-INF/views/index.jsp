<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
var cur = -1;
$(searchList());
function searchList(op) {
	$.ajax({
		url : "http://localhost:8090/api/productlist",
		type : "GET",
		dataType : "json",
		success : function(res) {
			$('#pList').children().remove();
			var list = res['resvalue'];
			for (var i = 0; i <list.length; i++) {
				$('#pList').append(
						"<li onclick='searchInfo(" + '"' + list[i]['id']
								+ '"' + ")'>" + list[i]['id'] + "</li>");
			}
			if (op == null) {
				$('#resdiv').html(res['resmsg']);
			}
			else {
				$('#resdiv').html(op);
			}
		},
		error : function(request, status, error) {
		}
	});
}


function searchInfo(id) {
	$.ajax({
		url : "http://localhost:8090/api/productview/" + id,
		type : "GET",
		dataType : "json",
		success : function(res) {
			var item = res['resvalue'];
			$('#pid').val(item['id']);
			$('#pname').val(item['name']);
			$('#pprice').val(item['price']);
			$('#pinfo').val(item['info']);
			cur = item['id'];
			$('#resdiv').html(res['resmsg']);
		},
		error : function(request, status, error) {
		}
	});
}

function productadd(){
	var product = new Object();
	product.id = $("#pid").val();
	product.name = $("#pname").val();
	product.price = $("#pprice").val();
	product.info = $("#pinfo").val();
	var json = JSON.stringify(product);
	
	$.ajax({
		url : "http://localhost:8090/api/productregister",
		type : "POST",
		contentType : "application/json",
		dataType : "json",
		data : json,
		success : function(res) {
			searchList(res['resmsg']);
			clearItem();
			cur = -1;
		},
		error : function(request, status, error) {
		}
	});
}

function productupdate(){
	if(cur==-1) return;
	var product = new Object();
	product.id = $('#pid').val();
	product.name = $('#pname').val();
	product.price = $('#pprice').val();
	product.info = $('#pinfo').val();
	var json = JSON.stringify(product);
	
	$.ajax({
		url : "http://localhost:8090/api/productupdate/"+product.id,
		type : "PUT",
		contentType: "application/json",
		dataType : "json",
		data : json,
		success : function(res){
			searchList(res['resmsg']);
			clearItem();
			cur = -1;
		},
		error : function(request, status, error){
		}
	});
}

function productdelete(){
	if(cur==-1) 
		return;
	$.ajax({
		url : "http://localhost:8090/api/productdelete/" + cur,
		type : "DELETE",
		dataType : "json",
		success : function(res){
			searchList(res['resmsg']);
			clearItem();
			cur = -1;
		},
		error : function(request, status, error){
		}
	});
}


function clearItem() {
	$('#id').val('');
	$('#name').val('');
	$('#price').val('');
	$('#info').val('');
}

</script>
</head>
<body>
	<H1 style="text-align: center;">Welcome To SSAFY!</H1>
	<hr>
	<br>
	<h2>상품 관리</h2>
	<input type="button" onclick="searchList()" value="목록조회"/>
	&nbsp;(상세 내용을 조회하기 위해서 목록의 아이템을 클릭하세요.)
	<br>
	
	<div class="productList">
		<ul class="pList" id="pList">
		</ul>
	</div>
	
	<input type="button" onclick="productadd()" value="추가" />&nbsp;
	<input type="button" onclick="productupdate()" value="수정" />&nbsp;
	<input type="button" onclick="productdelete()" value="삭제" />
	<br><br><br>
	
	<div class="productviewdiv">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" id="pid" name="pid" style="width: 150px"/></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="pname" name="pname"style="width: 150px"/></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" id="pprice" name="pprice"  style="width: 150px"/></td>
			</tr>
		</table>
		<textarea rows="5" cols="100" id="pinfo" name="pinfo" >
		</textarea>
	</div>
	
	<div style="width:300px;">
		<span style="font-size:15px;" id="resdiv"></span>
	</div>
</body>
</html>