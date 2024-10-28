<%--
  Created by IntelliJ IDEA.
  User: dangb
  Date: 23/10/2024
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Quản lý thông tin sách</title>
</head>
<body>
<c:url value="/admin/sach/them" var="urlSave"/>
<c:url value="/admin/sach/sua" var="urlUpdate"/>
<c:url value="/admin/sach/xoa" var="urlDelete"/>
<div style="width: 100%; text-align: center">
    <h2>Quản lý thông tin sách</h2>
</div>
<div style="width: 100%; text-align: right">
    <a href="${urlSave}">Thêm mới</a>
</div>
<table border="1" style="width:100%; border-collapse: collapse">
    <tr>
        <th>Ảnh sách</th>
        <th>Mã sách</th>
        <th>Tên sách</th>
        <th>Mô tả</th>
        <th>Giá sách</th>
        <th>Ngày tạo</th>
        <th>Tác giả</th>
        <th>Mã CĐ</th>
        <th style="width:40px;"></th>
        <th style="width:40px;"></th>
    </tr>
    <c:if test="${not empty lstSach}">
        <c:forEach var="s" items="${lstSach}">
            <tr style="border: 1px black solid">
                <td>${s.anhSach}</td>
                <td>${s.maSach}</td>
                <td>${s.tenSach}</td>
                <td>${s.moTa}</td>
                <td>${s.giaSach}</td>
                <td>${s.ngayTao}</td>
                <td>${s.tacGia}</td>
                <td>${s.maChuDe}</td>
                <td> <a href="${urlUpdate}/${s.maSach}">Sửa</a></td>
                <td> <a href="${urlDelete}/${s.maSach}" onclick="return confirm('Bạn có chắc chắn muốn xóa thông tin này ?');">Xóa</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
