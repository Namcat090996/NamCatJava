<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/28/2024
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Declare tag library of Spring MVC --%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <th>Mã chủ đề</th>
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
                <td>
                    <fmt:formatNumber value="${s.giaSach}" pattern="#,##0.###"/>đ
                </td>
                <td>
                    <fmt:formatDate value="${s.ngayTao}" pattern="dd-MM-yyyy"/>
                </td>
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
