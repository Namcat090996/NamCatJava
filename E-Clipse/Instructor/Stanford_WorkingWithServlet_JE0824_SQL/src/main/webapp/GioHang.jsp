<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,vn.com.stanford.je0824.workingwithservlet.model.*" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
<%@include file="header.jsp" %>
<%@include file="menu.jsp" %>
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
<c:forEach var="s" items="<%=lstSach %>">
<tr>
	<td>
	<img src='images/<c:out value="${s.anhSach}"/>' width="100" height="120" /></td>
	<td><c:out value="${s.id}"/></td>
	<td><c:out value="${s.tenSach}"/></td>
	<td><c:out value="${s.moTa}"/></td>
	<td><c:out value="${s.giaSach}"/></td>
	<td><c:out value="${s.tacGia}"/></td>
	<td>
	<c:out value="${s.soLuong}"/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
<%@include file="footer.jsp" %>	
</body>
</html>