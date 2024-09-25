<%@page
	import="java.util.ArrayList, java.util.List, vn.com.namcat.servletwork.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới hoặc sửa thông tin sách</title>
</head>
<% List<Sach> lstSach = DataProvider.getSachBus().layDanhSach(); %>
<body>
	<div style="width: 100%; text-align: center;">
		<h2 style="text-transform: uppercase;">Thêm, sửa thông tin sách</h2>
	</div>
	<div style="width: 500px; margin: 30px auto">
		<form method="post">
			<fieldset style="display: inline-block; border-radius: 5px ">
				<legend>Nhập thông tin sách</legend>
				<table>
					<% int sachId = Integer.parseInt(request.getParameter("id")); %>
					<% Sach objSach = DataProvider.getSachBus().layChiTietTheoMa(sachId);%>					
					<tr>
						<td>Tên sách:</td>
						<td><input type="text" name="txtTenSach" value="<%= objSach.getTenSach() %>" /></td>
					</tr>
					<tr>
						<td>Mô tả:</td>
						<td><textarea style="width: 170px" name="txtMoTa" rows=5 ><%= objSach.getMoTa() %></textarea></td>
					</tr>
					<tr>
						<td>Ảnh sách:</td>
						<td><input type="text" name="txtAnhSach" /> &nbsp; <input
							type="file" style="width: 190px"></td>
					</tr>
					<tr>
						<td>Giá sách:</td>
						<td><input type="text" name="txtGiaSach" value="<%= objSach.getGiaSach() %>" /></td>
					</tr>
					<tr>
						<td>Tác giả:</td>
						<td><input type="text" name="txtTacGia" value="<%= objSach.getTacGia() %>" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Cập nhật" name="btnCapNhat" />
							&nbsp; &nbsp; <a href="QuanLySach.jsp">Trở lại</a></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>