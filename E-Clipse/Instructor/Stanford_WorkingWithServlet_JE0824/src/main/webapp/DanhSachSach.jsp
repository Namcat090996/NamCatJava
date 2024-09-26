<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.ArrayList,java.util.List,vn.com.stanford.je0824.workingwithservlet.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý thông tin sách</title>
<style type="text/css">
#container {
	display: inline-block;
	width: 100%;
	text-align: center;
}

#container .bookinfo {
	width: 200px;
	height: 350px;
	float: left;
	display: inline-block;
	border: 1px solid silver;
	padding: 5px;
	
}

#container .bookinfo h3 {
	font-size: 20px;
	height: 50px;
}

#container .bookinfo img {
	text-align: center;
}
#container .bookinfo p {
	font-size: 16px;
	text-align: justify;
}
</style>
</head>
<%
//Lấy danh sách sách
List<Sach> lstSach = DataProvider.getSachBus().layDanhSach();
%>
<body>
<form>
	<div style="width: 100%; text-align: center;">
		<h2 style="text-transform: uppercase;">Danh sách thông tin sách
			dành cho bạn</h2>
	</div>
	<div id="container">
		<%
		for (Sach s : lstSach) {
		%>
		<div class="bookinfo">
			<h3><%=s.getTenSach()%></h3>
			<p>
				<img src="images/<%=s.getAnhSach()%>" width="120" height="130" />
			</p>
			<p>
				<%=s.getMoTa()%>
			</p>
			<p style="text-align:right;">
			<a href="GioHangServlet?id=<%=s.getId() %>">Thêm giỏ hàng</a>
			</p>
		</div>
		<%} %>
	</div>
	</form>
</body>
</html>