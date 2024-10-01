<%@page import="java.util.ArrayList"%>
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
List<Sach> lstSach = new ArrayList<Sach>();

if(session.getAttribute("gioHang") != null)
{
	lstSach = (List<Sach>)session.getAttribute("gioHang");
}
%>
<body>
<%@ include file="Header.jsp"%>
<jsp:include page="Menu.jsp"></jsp:include>
	<div style="text-align: center;">
		<h2 style="text-transform: uppercase;">Giỏ hàng của bạn</h2>
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
				<th>Số lượng</th>
			</tr>
			<tbody>
				<%
				for(Sach s: lstSach) {				
				%>
				<tr>
					<td><img alt="" src="images/<%=s.getAnhSach() %>" width="100px" height="120px"></td>
					<td><%=s.getId() %></td>
					<td><%=s.getTenSach() %></td>
					<td><%=s.getMoTa() %></td>
					<td><%=s.getGiaSach() %></td>
					<td><%=s.getTacGia() %></td>
					<td><%=s.getSoLuong() %></td>
				</tr>
				<% } %>	
			</tbody>
		</table>
	</form>
<%@ include file="Footer.jsp"%>
</body>
</html>