<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList," %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String tenCongTy = "Stanford - Dạy lập trình";
%>
<h2>
<c:out value="Làm việc với Tag Libs"></c:out>
</h2>
<h3>
<c:out value="<%=tenCongTy %>"></c:out>
</h3>
	<c:set var="hoTen" value="Nguyễn Văn Anh"></c:set>
	<p>Họ tên là: <c:out value="${hoTen}"></c:out></p>
	<!-- Thẻ tag tạo ra đối tượng kèm thuộc tính và giá trị -->
	<jsp:useBean id="book" class="vn.com.stanford.je0824.workingwithservlet.model.Sach" scope="session"></jsp:useBean>
	<!-- Gán giá trị cho các thuộc tính -->
	<c:set target="${book}" property="id" value="100"></c:set>
	<c:set target="${book}" property="tenSach" value="Làm việc với Servlet và JSP"></c:set>
	<c:set target="${book}" property="tacGia" value="Quang Đăng"></c:set>
<h3>Thông tin sách</h3>
<p>
	ID: <c:out value="${book.id}"></c:out><br>
	Tên sách: <c:out value="${book.tenSach}"></c:out><br>
	Tác giả: <c:out value="${book.tacGia}"></c:out><br>
	<c:if test="${book.id == 100}">Đây là cuốn có mã 100</c:if>
</p>
<form action="">
	Nhập tuổi:
	<input type="text" name="tuoi" />
	<br>
	<input type="submit" name="btnThucHien" value="Thực hiện" />
	<br>
	<c:choose>
		<c:when test="${empty param.tuoi}">
		Bạn cần nhập tuổi
		</c:when>
		<c:when test="${param.tuoi < 13}">
		Bạn còn bé
		</c:when>
		<c:when test="${param.tuoi > 13 && param.tuoi < 60}">
		Bạn còn trẻ
		</c:when>
		<c:otherwise>
		Bạn đã già
		</c:otherwise>
	</c:choose>
</form>
<form action="">

</form>

<h3>Danh sách sinh viên: </h3>
<table border="1" style="border-collapse: collapse;">
<tr>
	<th>STT</th>
	<th>Họ tên</th>
</tr>
<tbody>
<c:forEach var="s" items="<%= %>" varStatus="i"></c:forEach>
<tr>
	<td>
	<c:out value=""></c:out>
	</td>
</tr>
</tbody>

</table>
</body>
</html>