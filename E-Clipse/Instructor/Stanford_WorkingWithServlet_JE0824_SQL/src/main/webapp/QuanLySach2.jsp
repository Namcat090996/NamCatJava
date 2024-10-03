<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,vn.com.stanford.je0824.workingwithservlet.model.*" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý thông tin sách</title>
</head>
<%
//Lấy danh sách sách
SachBusiness sachBusiness = new SachBusiness();

List<Sach> lstSach = sachBusiness.layDanhSach();

%>
<body>
<%@include file="header.jsp" %>
<%@include file="menu.jsp" %>
<div style="width:100%; text-align:center;">
<h2 style="text-transform: uppercase;">Quản lý thông tin sách</h2>
</div>
<div style="width: 100%; text-align: right">
<a href="SachAdd.jsp">Thêm mới</a>
</div>
<table border="1" style="width:100%; border-collapse:collapse;">
<tr>
	<th>
	Ảnh sách
	</th>
	<th>
	Mã sách
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
	</th>
</tr>
<tbody>
<c:forEach var="s" items="<%=lstSach %>">
<tr>
	<td>${s.anhSach}</td>
	<td>${s.maSach}</td>
	<td>${s.tenSach}</td>
	<td>${s.moTa}</td>
	<td>${s.giaSach}</td>
	<td>${s.tacGia}</td>
	<td>
	<a href="SachAdd.jsp?id=${s.maSach}" title="Nhấn vào đây để sửa thông tin">Sửa</a>
	&nbsp;
	<a href="SachServletXoa?id=${s.maSach}" title="Nhấn vào đây để xóa thông tin">Xóa</a>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
<%@include file="footer.jsp" %>	
</body>
</html>