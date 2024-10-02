<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, java.util.ArrayList" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Làm việc với JSTL trong Java</title>
</head>
<body>
<%
String tenCongTy = "Stanford - Dạy lập trình";
%>
<h2>
<c:out value="Làm việc với Tag Libs"/>

</h2>
<h3>
<c:out value="<%=tenCongTy %>"/>
</h3>
<c:set var="hoTen" value="Nguyễn Văn Anh"/>
<p>
Họ tên là: <c:out value="${hoTen}"/>
</p>
<p>
<jsp:useBean id="book" class="vn.com.stanford.je0824.workingwithservlet.model.Sach" scope="session">
</jsp:useBean>
<!-- Gán giá trị cho các thuộc tính -->
<c:set target="${book}" property="id" value="101"/>
<c:set target="${book}" property="tenSach" value="Làm việc với Servlet và JSP"/>
<c:set target="${book}" property="tacGia" value="Quang Đăng"/>
</p>
<h3>Thông tin sách:</h3>
<p>
Id:<c:out value="${book.id}"/><br>
Tên sách: <c:out value="${book.tenSach}"/><br>
Tác giả: <c:out value="${book.tacGia}"/><br>
<c:if test="${book.id == 100}">
Đây là cuốn sách có mã 100
</c:if>
</p>
<form>
Nhập tuổi:
<input type="text" name="tuoi"/>
<br>
<input type="submit" name="btnThucHien" value="Thực hiện"/>
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
<br>
Nhập số điện thoại:
<input type="text" name="txtDienThoai"/>
<br>
<input type="submit" name="btnThucHien" value="Thực hiện"/>
<br>
<c:set var="phoneNumber" value="${param.txtDienThoai}"/>
<ul>
<c:forTokens items="${phoneNumber}" delims="-" var="par">
	<li>${par}</li>
</c:forTokens>
</ul>
</form>
<%
List<String> lstThongTin = new ArrayList();

lstThongTin.add("Nam");
lstThongTin.add("Huy");
lstThongTin.add("Cát");
lstThongTin.add("Trúc");
lstThongTin.add("Phương");
lstThongTin.add("Mạnh");

%>
<h3>Danh sách sinh viên:</h3>
<table border="1" style="border-collapse: collapse;">
<tr>
<th>
STT
</th>
<th>
Họ tên
</th>
</tr>
<tbody>
<c:forEach var="s" items="<%=lstThongTin %>" varStatus="i" >
<tr>
	<td>
	<c:out value="${i.index+1}"/>
	</td>
	<td>
		
		<c:out value="${s}"/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>