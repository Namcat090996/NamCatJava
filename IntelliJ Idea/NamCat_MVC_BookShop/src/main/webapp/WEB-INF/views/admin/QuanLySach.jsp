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
    <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css"/>'>
    <script type="text/javascript" src='<c:url value="/resources/js/jquery-3.7.1.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/bootstrap.js"/>'></script>
</head>
<body>
<c:url value="/admin/sach/them" var="urlInsert"/>
<c:url value="/admin/sach/sua" var="urlUpdate"/>
<c:url value="/admin/sach/xoa" var="urlDelete"/>
<c:url value="/admin/sach" var="urlTimKiem"/>
<div style="text-align: center; margin-top: 10px">
    <h2>Quản lý thông tin sách</h2>
</div>
<div class="container-fluid">
    <div style="text-align: right; margin-bottom: 5px">
        <a class="btn btn-primary" href="${urlInsert}">Thêm mới</a>
    </div>
    <table class="table table-striped table-bordered">
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
            <tr>
                <td>${s.anhSach}</td>
                <td>${s.maSach}</td>
                <td>${s.tenSach}</td>
                <td>${s.moTa}</td>
                <td>${s.giaSach}</td>
                <td>${s.ngayTao}</td>
                <td>${s.tacGia}</td>
                <td>${s.maChuDe}</td>
                <td>
                    <a class="btn btn-primary" href="${urlUpdate}/${s.maSach}">Sửa</a>
                </td>
                <td>
                    <a class="btn btn-danger" href="${urlDelete}/${s.maSach}" onclick="return confirm('Bạn có chắc chắn muốn xóa thông tin này không ?')">Xóa</a>
                </td>
            </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
</body>
</html>
