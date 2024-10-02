<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkingWithJSTL</title>
</head>
<body>
<%!
String tenCongTy = "Stanford - Dạy lập trình hướng đối tượng";
%>
	<h2>
		<c:out value="Làm việc với Tag Libs"></c:out>
	</h2>
	<h3>
		<c:out value="<%=tenCongTy %>"></c:out>
	</h3>
	<c:set var="hoTen" value="Huỳnh Nam Cát"></c:set>
	<p>Họ tên là: <c:out value="${hoTen}"></c:out></p>
	<jsp:useBean id="book" class="vn.com.namcat.servletworking.model.Sach" scope="session"></jsp:useBean>
	<c:set target="${book}" property="id" value="50"></c:set>
	<c:set target="${book}" property="tenSach" value="Chu chim non"></c:set>
	<c:set target="${book}" property="tacGia" value="Author"></c:set>
	<h3>Thông tin sách: </h3>
	<p>
		Id: <c:out value="${book.id}"></c:out><br>
		Tên sách: <c:out value="${book.tenSach}"></c:out><br>
		Tác giả: <c:out value="${book.tacGia}"></c:out>
	</p>
	<c:if test="${book.id == 50}">
		This is the book with index 100
	</c:if>
	<form action="">Enter the age:
	<input type="text" name="tuoi"><br>
	<input type="submit" name="btnThucHien" value="Perform"><br>
	<c:choose>
		<c:when test="${empty param.tuoi}">You must enter the age</c:when>
		<c:when test="${param.tuoi < 13}">You're a kid</c:when>
		<c:when test="${param.tuoi > 13 && param.tuoi < 60}">You're young</c:when>
		<c:otherwise>You're old</c:otherwise>
	</c:choose>
	<br>
	Nhập số điện thoại:
	<input type="text" name="txtSoDienThoai"/>
	<br>
	<input type="submit" name="btnThucHien" value="Thực hiện"/>
	<br>
	<c:set var="phoneNumber" value="${param.txtSoDienThoai}"></c:set>
	<ul>
	<c:forTokens items="${phoneNumber}" delims="-" var="par">
	<li>
		<c:out value="${par}"></c:out>
	</li>	
	</c:forTokens>
	</ul>
	</form>
	<h3>List of student</h3>
	<%
	List<String> lstName = new ArrayList<String>();
	
	lstName.add("Nam");
	lstName.add("Cat");
	%>
	
	<table border="1" style="border-collapse: collapse; text-align: center;">
		<tr>
			<th>STT</th>
			<th>Name</th>
		</tr>
		<tbody>
			<c:forEach var="s" items="<%=lstName %>" varStatus="id">
				<tr>
					<td>
						<c:out value="${id.index + 1}"></c:out>
					</td>				
					<td>
						<c:out value="${s}"></c:out>
					</td>
				</tr>				
			</c:forEach>
	
		</tbody>
	</table>
	
</body>
</html>