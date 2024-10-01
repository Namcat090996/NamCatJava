<%@page import="vn.com.namcat.servletworking.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý thông tin sách</title>
<style type="text/css">
.wrapper {
	display: flex;
	width: 80%;
	margin: 0px auto;
	justify-content: center;
	align-items: center;
	flex-wrap: wrap;
}

.wrapper .wrapper__item {
	border: 1px solid silver;
	display: inline-block;
	width: 17%;
	height: 370px;
	margin: 5px;
	border-color: olive;
	border-radius: 4px;
}

.wrapper__item p {
	margin: 10px 10px 30px 7px;
	height: 60px;
}

.wrapper__item h3 {
	text-align: center;
	margin-top: 20px;
	margin-bottom: 35px;
	height: 20px;
	opacity: 80%;
}
</style>
</head>
<%
//Get the book list
List<Sach> lstSach = DataSupplier.getSachBus().layDanhSach();
%>
<body>
<%@ include file="Header.jsp"%>
<jsp:include page="Menu.jsp"></jsp:include>
	<h2 style="text-transform: uppercase; text-align: center;">Danh sách thông tin sách dành cho bạn</h2>
	<form action="">
		<div class="wrapper">
			<%
			for (Sach s : lstSach) {
			%>
			<div class="wrapper__item">
				<h3><%=s.getTenSach()%></h3>
				<div style="text-align: center;">
					<img alt="" src="images/<%=s.getAnhSach()%>" width="130px" height="150px">
				</div>
				<p><%=s.getMoTa()%></p>
				<div style="text-align: center;">
					<a href="BookCartServlet?id=<%=s.getId()%>">Thêm vào giỏ hàng</a>
				</div>
	
			</div>
			<%
			}
			%>
		</div>
	</form>
<%@ include file="Footer.jsp"%>
</body>
</html>