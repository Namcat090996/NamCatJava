<%--
  Created by IntelliJ IDEA.
  User: dangb
  Date: 25/10/2024
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Thêm mới hoặc sửa thông tin sách</title>
    <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css"/>'>
    <script type="text/javascript" src='<c:url value="/resources/js/jquery-3.7.1.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/bootstrap.js"/>'></script>
    <style>
        .errorfinfo
        {
            color: red;
        }

        .custom-width
        {
            width: 5%;
        }
    </style>
</head>
<body>

<c:url value="/admin/sach/themMoiSach" var="themMoiSach"/>
<c:url value="/admin/sach" var="troVeDanhSach"/>
<form:form method="post" action="${themMoiSach}" modelAttribute="sach" acceptCharset="utf-8" enctype="multipart/form-data">
    <fieldset>
        <legend>Nhập thông tin sách</legend>
        <div class="container-fluid">
            <div class="row">
                <label class="col-md-1">Mã sách:</label>
                <div class="col-md-6">
                    <form:input path="maSach" cssClass="form-control"/><br>
                    <form:errors path="maSach" cssClass="errorfinfo"/>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Tên sách:</label>
                <div class="col-md-10">
                    <form:input path="tenSach" cssClass="form-control"/><br>
                    <form:errors path="tenSach" cssClass="errorfinfo"/>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Mô tả:</label>
                <div class="col-md-10">
                    <form:textarea path="moTa" rows="5" cssClass="form-control"/><br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Ảnh sách:</label>
                <div  class="col-md-10">
                    <input type="file" name="fUpload"/>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Giá sách:</label>
                <div  class="col-md-6">
                    <form:input path="giaSach" cssClass="form-control"/><br>
                    <form:errors path="giaSach" cssClass="errorfinfo"/>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Tác giả:</label>
                <div  class="col-md-10">
                    <form:input path="tacGia" cssClass="form-control"/><br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Mã CĐ:</label>
                <div  class="col-md-10">
                    <form:select path="maChuDe" cssClass="form-control">
                        <form:option value="">---Chọn chủ đề---</form:option>
                        <c:forEach var="cd" items="${chuDeList}">
                            <form:option value="${cd.maChuDe}">${cd.tenChuDe}</form:option>
                        </c:forEach>
                    </form:select>
                    <br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2"></label>
                <div  class="col-md-10">
                    <input type="submit" value="Cập nhật" class="btn btn-primary"/>
                    &nbsp;
                    <a href="${troVeDanhSach}" class="btn btn-dark">Trở lại</a>
                </div>
            </div>
            <div>
                <label></label>
                <div><br>
                    ${message}
                </div>
            </div>
        </div>
    </fieldset>
</form:form>
</body>
</html>
