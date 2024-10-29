<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/28/2024
  Time: 7:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Quản lý thông tin chủ đề</title>
</head>
<body>
<c:url value="/admin/chude/them" var="urlSave"/>
<c:url value="/admin/chude/sua" var="urlUpdate"/>
<c:url value="/admin/chude/xoa" var="urlDelete"/>
<div style="width: 100%; text-align: center">
    <h2>Quản lý thông tin chủ đề</h2>
</div>
<div style="width: 100%; text-align: right">
    <a href="${urlSave}">Thêm mới</a>
</div>
<table border="1" style="width:100%; border-collapse: collapse">
    <tr>
        <th>Mã chủ đề</th>
        <th>Tên chủ đề</th>
        <th style="width:40px;"></th>
        <th style="width:40px;"></th>
    </tr>
    <c:if test="${not empty chuDe}">
        <c:forEach var="chuDe" items="${chuDe}">
            <tr style="border: 1px black solid">
                <td>${chuDe.maChuDe}</td>
                <td>${chuDe.tenChuDe}</td>
                <td> <a href="${urlUpdate}/${chuDe.maChuDe}">Sửa</a></td>
                <td> <a href="${urlDelete}/${chuDe.maChuDe}" onclick="return confirm('Bạn có chắc chắn muốn xóa thông tin này ?');">Xóa</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
