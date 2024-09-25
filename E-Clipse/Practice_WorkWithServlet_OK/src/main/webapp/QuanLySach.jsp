<%@page
	import="java.util.ArrayList, java.util.List, vn.com.namcat.servletwork.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý thông tin sách</title>
</head>
<%
List<Sach> lstSach = DataProvider.getSachBus().layDanhSach();
%>
<body>
	<div style="width: 100%; text-align: center;">
		<h2 style="text-transform: uppercase;">Quản lý thông tin sách</h2>
	</div>
	<div style="width: 100%; text-align: right">
		<a href="SachAdd.jsp" title="Nhấn vào đây để thêm mới thông tin">Thêm mới</a>
	</div>
	<form action="">
		<table border="1" style="width: 100%; border-collapse: collapse;">
			<tr>
				<th>Ảnh sách</th>
				<th>Id</th>
				<th>Tên sách</th>
				<th>Mô tả</th>
				<th>Giá sách</th>
				<th>Tác giả</th>
			</tr>
			<tbody>
				<%
				for (int i = 0; i < lstSach.size(); i++) {
				%>
				<tr>
					<td><%=lstSach.get(i).getAnhSach()%></td>
					<td><%=lstSach.get(i).getId()%></td>
					<td><%=lstSach.get(i).getTenSach()%></td>
					<td><%=lstSach.get(i).getMoTa()%></td>
					<td><%=lstSach.get(i).getGiaSach()%></td>
					<td><%=lstSach.get(i).getTacGia()%></td>
					<td><a href="SachAdd.jsp?id=<%=lstSach.get(i).getId()%>"
						title="Nhấn vào đây để sửa thông tin">Sửa</a> &nbsp; <a href="#"
						title="Nhấn vào đây để xóa thông tin">Xóa</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</form>
</body>
</html>