<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,vn.com.stanford.je0824.workingwithservlet.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng của bạn</title>
</head>
<%
//Lấy danh sách sách tứ session
List<Sach> lstSach = new ArrayList();

if(session.getAttribute("gioHang") != null)
{
	lstSach = (List<Sach>)session.getAttribute("gioHang");
}
%>
<body>
<%@include file="Header.jsp" %>
<%@include file="Menu.jsp" %>
<div style="width:100%; text-align:center;">
<h2 style="text-transform: uppercase;">Giỏ hàng của bạn</h2>
</div>

<table border="1" style="width:100%; border-collapse:collapse;">
<tr>
	<th>
	Ảnh sách
	</th>
	<th>
	Id
	</th>
	<th>
	Tên sách
	</th>
	<th>
	Mô tả
	</th>
	<th>
	Giá sách
	</th>
	<th>
	Tác giả
	</th>
	<th>
	Số lượng
	</th>
</tr>
<tbody>
<%
for(Sach s : lstSach){
%>
<tr>
	<td><img src="images/<%=s.getAnhSach() %>" width="100" height="120"/></td>
	<td><%=s.getId() %></td>
	<td><%=s.getTenSach() %></td>
	<td><%=s.getMoTa() %></td>
	<td><%=s.getGiaSach() %></td>
	<td><%=s.getTacGia() %></td>
	<td>
	<%=s.getSoLuong() %>
	</td>
</tr>
<%} %>
</tbody>
</table>
<%@include file="Footer.jsp" %>
</body>
</html>