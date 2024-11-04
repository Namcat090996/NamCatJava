<%--
  Created by IntelliJ IDEA.
  User: dangb
  Date: 23/10/2024
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Quản lý thông tin sách</title>
    <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css"/>'>
    <script type="text/javascript" src='<c:url value="/resources/js/jquery-3.7.1.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/bootstrap.js"/>'></script>
    <style type="text/css">
        .custom-width {
            width: 5%;
            position: relative;
            left: 20px;
        }

        .search {
            position: relative;
            left: 20px;
        }

        .legend {
            position: relative;
            left: 20px;
            bottom: 5px;
        }
    </style>
</head>
<body>
<c:url value="/admin/sach/them" var="urlSave"/>
<c:url value="/admin/sach/sua" var="urlUpdate"/>
<c:url value="/admin/sach/xoa" var="urlDelete"/>
<c:url value="/images/" var="urlImage"/>
<c:url value="/admin/sach" var="urlTimKiem"/>
<div style="width: 100%; text-align: center; margin-top: 10px">
    <h2>Quản lý thông tin sách</h2>
</div>
<form:form action="${urlTimKiem}" modelAttribute="sach" acceptCharset="utf-8">
    <fieldset>
        <legend>Nhập thông tin tìm kiếm</legend>
        <div class="row">
            <label class="custom-width d-flex align-items-center justify-content-center">Từ khóa:</label>
            <div class="col-md-2">
            <form:input path="tuKhoa" cssClass="form-control"/>
            </div>
            <label class="custom-width d-flex align-items-center justify-content-center">Chủ đề:</label>
            <div class="col-md-2">
                <form:select path="maChuDe" cssClass="form-control">
                    <form:option value="">---Chọn chủ đề---</form:option>
                    <c:forEach var="cd" items="${chuDeList}">
                        <form:option value="${cd.maChuDe}">${cd.tenChuDe}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="col-md-2">
                <input type="submit" value="Tìm kiếm" name="btnTimKiem" class="search btn btn-primary"/>
            </div>
        </div>
    </fieldset>
</form:form>
<div class="container-fluid">
    <div style="width: 100%; text-align: right; margin-bottom: 5px">
        <a class="btn btn-primary" href="${urlSave}">Thêm mới</a>
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
                <td><img src="${urlImage}/${s.anhSach}" width="100" height="120" class="img-thumbnail"/> </td>
                <td>${s.maSach}</td>
                <td>${s.tenSach}</td>
                <td>${s.moTa}</td>
                <td>${s.giaSach}</td>
                <td>${s.ngayTao}</td>
                <td>${s.tacGia}</td>
                <td>${s.maChuDe}</td>
                <td> <a class="btn btn-primary" href="${urlUpdate}/${s.maSach}">Sửa</a></td>
                <td> <a class="btn btn-danger" href="${urlDelete}/${s.maSach}" onclick="return confirm('Bạn có chắc chắn muốn xóa thông tin này ?');">Xóa</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</div>
</body>
</html>
