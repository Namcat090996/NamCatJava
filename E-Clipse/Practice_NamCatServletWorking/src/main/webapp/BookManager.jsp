<%@page import="vn.com.namcat.servletworking.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý thông tin sách</title>
<script type="text/javascript">
	function confirmDelete() {
		return confirm("Bạn có chắc chắn muốn xóa sách này ?");
	}
</script>
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
			<c:forEach var="s" items="<%=lstSach %>">
				<tr>
					<td>
						<c:out value="${s.anhSach}"></c:out>
					</td>
					<td>
						<c:out value="${s.id}"></c:out>
					</td>
					<td>
						<c:out value="${s.tenSach}"></c:out>
					</td>
					<td>
						<c:out value="${s.moTa}"></c:out>
					</td>
					<td>
						<c:out value="${s.giaSach}"></c:out>
					</td>
					<td>
						<c:out value="${s.tacGia}"></c:out>
					</td>
					<td>
						<a title="Nhấn vào đây để sửa thông tin" href="BookInfo.jsp?id=<c:out value='${s.id}'></c:out>">Sửa</a> &nbsp;
						<a title="Nhấn vào đây để xóa thông tin" href="BookDelete?id=<c:out value='${s.id}'></c:out>" onclick="return confirmDelete();">Xóa</a>
					</td>
				</tr>			
			</c:forEach>
			</tbody>
		</table>
	</form>
<%@ include file="Footer.jsp"%>
</body>
</html>