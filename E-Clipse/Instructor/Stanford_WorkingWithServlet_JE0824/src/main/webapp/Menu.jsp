<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#menu {
	display: inline-block;
	height: 50px;
	width: 100%;
	background-color: navy;
}

#menu li {
	float: left;
	width: 100px;
	list-style-type: none;
}

#menu li a {
	color: #fff;
	font-size: 18px;
	text-decoration: none;
}

#menu li a:hover {
	font-size: 20px;
}
</style>
</head>
<body>
	<div id="menu">
		<ul>
			<li><a href="DanhSachSach.jsp">Trang chủ</a></li>
			<li><a href="QuanLySach.jsp">QL sách</a></li>
			<li><a href="GioHang.jsp">Giỏ hàng</a></li>
		</ul>
	</div>
</body>
</html>