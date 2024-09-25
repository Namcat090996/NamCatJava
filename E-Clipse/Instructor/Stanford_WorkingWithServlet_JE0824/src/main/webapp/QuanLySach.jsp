<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.ArrayList,java.util.List,vn.com.stanford.je0824.workingwithservlet.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý thông tin sách</title>
</head>
<%
//Lấy danh sách sách
List<Sach> lstSach = DataProvider.getSachBus().layDanhSach();
%>
<body>
	<div style="width: 100%; text-align: center;">
		<h2 style="text-transform: uppercase;">Quản lý thông tin sách</h2>
	</div>
	<div style="width: 100%; text-align: right">
		<a href="SachAdd.jsp">Thêm mới</a>
	</div>
	<table border="1" style="width: 100%; border-collapse: collapse;">
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
			for (Sach s : lstSach) {
			%>
			<tr>
				<td><%=s.getAnhSach()%></td>
				<td><%=s.getId()%></td>
				<td><%=s.getTenSach()%></td>
				<td><%=s.getMoTa()%></td>
				<td><%=s.getGiaSach()%></td>
				<td><%=s.getTacGia()%></td>
				<td><a href="SachAdd.jsp?id=<%=s.getId()%>"
					title="Nhấn vào đây để sửa thông tin">Sửa</a> &nbsp; <a href="#"
					title="Nhấn vào đây để xóa thông tin">Xóa</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>