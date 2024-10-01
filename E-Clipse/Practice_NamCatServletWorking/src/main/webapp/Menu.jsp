<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.wrapper-menu {
	background-color: lightblue;
	display: inline-block;
	width: 100%;
}

.menu {
	display: inline-block;
}

.menu li {
	float: left;
	list-style-type: none;
	width: 100px;
}

.menu a {
	text-decoration: none;
	color: black;
	font-size: 18px;
}

.menu a:hover {
	font-size: 20px;
}
</style>
</head>
<body>
<div class="wrapper-menu">
	<ul class="menu">
		<li>
			<a href="BookManager.jsp">Trang chủ</a>
		</li>
		<li>
			<a href="BookSelection.jsp">QL sách</a>
		</li>
		<li>
			<a href="BookShoppingCart.jsp">Giỏ hàng</a>
		</li>
	</ul>
</div>
</body>
</html>