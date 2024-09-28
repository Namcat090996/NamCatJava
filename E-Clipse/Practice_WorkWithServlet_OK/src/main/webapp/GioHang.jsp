<%@page
	import="java.util.ArrayList, java.util.List, vn.com.namcat.servletwork.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng của bạn</title>
</head>
<%
List<Sach> lstSach = new ArrayList<Sach>();

if(session.getAttribute("gioHang") != null)
{
	lstSach = (List<Sach>)session.getAttribute("gioHang");
}
%>
<body>
	<div style="width: 100%; text-align: center;">
		<h2 style="text-transform: uppercase;">Giỏ hàng của bạn</h2>
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
				<th>Số lượng</th>
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
					<td>
						<%=lstSach.get(i).getSoLuong() %>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</form>
</body>
</html>