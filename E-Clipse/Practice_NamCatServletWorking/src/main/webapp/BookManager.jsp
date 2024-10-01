<%@page import="vn.com.namcat.servletworking.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý thông tin sách</title>
</head>
<%
//Get the book list
List<Sach> lstSach = DataSupplier.getSachBus().layDanhSach();
%>
<body>
<%@ include file="Header.jsp"%>
<jsp:include page="Menu.jsp"></jsp:include>
	<div style="text-align: center;">
		<h2 style="text-transform: uppercase;">Quản lý thông tin sách</h2>
	</div>
	<div style="text-align: right; margin-bottom: 5px;">
		<a href="BookInfo.jsp" style="color: red">Thêm mới</a>
	</div>
	<form action="">
		<table border="1" style="border-collapse: collapse; width: 100%">
			<tr>
				<th>Ảnh sách</th>
				<th>Id</th>
				<th>Tên sách</th>
				<th>Mô tả</th>
				<th>Giá sách</th>
				<th>Tác giả</th>
				<th></th>
			</tr>
			<tbody>
				<%
				for(Sach s: lstSach) {
				
				%>
				<tr>
					<td><%=s.getAnhSach() %></td>
					<td><%=s.getId() %></td>
					<td><%=s.getTenSach() %></td>
					<td><%=s.getMoTa() %></td>
					<td><%=s.getGiaSach() %></td>
					<td><%=s.getTacGia() %></td>
					<td>
						<a title="Nhấn vào đây để sửa thông tin" href="BookInfo.jsp?id=<%=s.getId()%>">Sửa</a> &nbsp;
						<a title="" href="#">Sửa</a>
					</td>
				</tr>
				<% } %>	
			</tbody>
		</table>
	</form>
<%@ include file="Footer.jsp"%>
</body>
</html>