<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Làm việc với JSP trong lập trình Java Web</title>
</head>
<body>
	<%! String loiChao = "Chào mừng bạn đến với JSP !"; %>
	<%--Viết theo 1 khối code --%>
	<%
	String hoTen = "Nguyễn Minh Anh";
	String diaChi = "Hà Nội";
	int tuoi = 25;
	
	List<String> lstThongTin = new ArrayList<String>();
	
	lstThongTin.add("Táo");
	lstThongTin.add("Mận");
	lstThongTin.add("Đào");
	lstThongTin.add("Cam");
	lstThongTin.add("Bưởi");
	%>
	<%--Hiển thị thông tin --%>
	<h1><%= loiChao %></h1>
	<h3>Thông tin về sinh viên</h3>
	<ul>
		<li><b>Họ tên: <%= hoTen %></b></li>
		<li><i>Tuổi: <%= tuoi %></i></li>
		<li style="color: red">Địa chỉ: <%= diaChi %></li>
	</ul>
	<h3>Thông tin hoa quả</h3>
	<ul>
	<%
	for(int i = 0; i < lstThongTin.size(); i++) { %>
	<li><%= lstThongTin.get(i) %></li>
	<% } %>
	</ul>

</body>
</html>