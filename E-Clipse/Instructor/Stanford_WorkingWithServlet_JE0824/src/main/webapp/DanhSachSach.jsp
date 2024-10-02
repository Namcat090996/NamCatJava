<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.ArrayList,java.util.List,vn.com.stanford.je0824.workingwithservlet.model.*"%>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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
<%@include file="header.jsp" %>

<jsp:include page="menu.jsp" />
<form>
	<div style="width: 100%; text-align: center;">
		<h2 style="text-transform: uppercase;">Danh sách thông tin sách
			dành cho bạn</h2>
	</div>
	<div id="container">
		<c:forEach var="s" items="<%=lstSach %>">
		<div class="bookinfo">
			<h3><c:out value="${s.tenSach}"/></h3>
			<p>
				<img src='images/<c:out value="${s.anhSach}"/>' width="120" height="130" />
			</p>
			<p>
				<c:out value="${s.moTa}"/>
			</p>
			<p style="text-align:right;">
			<a href='GioHangServlet?id=<c:out value="${s.id}"/>'>Thêm giỏ hàng</a>
			</p>
		</div>
		</c:forEach>
	</div>
	</form>
<%@include file="footer.jsp" %>	
</body>
</html>