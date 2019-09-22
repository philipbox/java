<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body>
	<nav>
		<ul>
			<li><a href="main.do?action=listmem">회원 관리</a></li>
			<li><a href="product.do?action=product_list">상품 관리</a></li>
			<li><a href="main.do?action=logoutmem">로그아웃</a>
		</ul>
	</nav>
</body>