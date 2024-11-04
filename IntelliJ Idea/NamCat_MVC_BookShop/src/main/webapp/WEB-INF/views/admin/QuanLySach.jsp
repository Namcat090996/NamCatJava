<%--
  Created by IntelliJ IDEA.
  User: Dell Precision 7550
  Date: 11/4/2024
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix ="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Quản lý thông tin sách</title>
</head>
<body>
<c:url value="/admin/sach/them" var="urlInsert"/>
<c:url value="/admin/sach/sua" var="urlUpdate"/>
<c:url value="/admin/sach/xoa" var="urlDelete"/>
<c:url value="/admin/sach" var="urlTimKiem"/>
<div style="text-align: center; margin-top: 10px">
    <h2>Quản lý thông tin sách</h2>
</div>
<div style="text-align: right">
    <a href="#">Thêm mới</a>
</div>
<table>

</table>
</body>
</html>
