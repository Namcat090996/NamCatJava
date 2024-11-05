<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/4/2024
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix ="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Thêm mới hoặc sửa thông tin sách</title>
    <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css"/>'>
    <script type="text/javascript" src='<c:url value="/resources/js/jquery-3.7.1.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/bootstrap.js"/>'></script>
    <style type="text/css">
        .errorInfo {
            color: red;
            font-family: Arial;
            font-style: italic;
        }

        .label-width {
            width: 7%;
            padding-right: 0px;
        }

        .row-wrapper {
            margin-top: 10px;
        }

        .input-style {
            margin-bottom: 3px;
        }
    </style>
</head>
<body>
<c:url value="/admin/sach/themMoiSach" var="urlInsert"/>
<c:url value="/admin/sach" var="urlList"/>
<form:form method="post" action="${urlInsert}" modelAttribute="sach" acceptCharset="utf-8" enctype="multipart/form-data">
    <fieldset>
        <legend>Nhập thông tin sách</legend>
        <div class="container-fluid">
            <div class="row row-wrapper">
                <label class="col-md-1 label-width">Mã sách (*):</label>
                <div class="col-md-6">
                    <form:input path="maSach" cssClass="form-control input-style" readonly="${not empty hSachId}"/>
                    <form:errors path="maSach" cssClass="errorInfo"/>
                    <input type="hidden" value="${hSachId}" name="idCheck">
                </div>
            </div>
            <div class="row row-wrapper">
                <label class="col-md-1 label-width">Tên sách (*):</label>
                <div class="col-md-6">
                    <form:input path="tenSach" cssClass="form-control input-style"/>
                    <form:errors path="tenSach" cssClass="errorInfo"/>
                </div>
            </div>
            <div class="row row-wrapper">
                <label class="col-md-1 label-width">Mô tả:</label>
                <div class="col-md-5 input-padding">
                    <form:textarea path="moTa" cssClass="form-control"/><br>
                </div>
            </div>
            <div class="row row-wrapper">
                <label class="col-md-1 label-width">Ảnh sách:</label>
                <div class="col-md-5 input-padding">
                    <input type="file" name="fUpload"/><br>
                </div>
            </div>
            <div class="row row-wrapper">
                <label class="col-md-1 label-width">Giá sách:</label>
                <div class="col-md-5 input-padding">
                    <form:input path="giaSach" cssClass="form-control input-style"/><br>
                </div>
            </div>
            <div class="row row-wrapper">
                <label class="col-md-1 label-width">Tác giả:</label>
                <div class="col-md-5 input-padding">
                    <form:input path="tacGia" cssClass="form-control"/><br>
                </div>
            </div>
            <div class="row row-wrapper">
                <label class="col-md-1 label-width">Chủ đề:</label>
                <div class="col-md-5 input-padding">
                    <form:select path="maChuDe" cssClass="form-control input-style">
                        <form:option value="">--- Chọn chủ đề ---</form:option>
                        <c:forEach var="cd" items="${lstChuDe}">
                            <form:option value="${cd.maChuDe}">${cd.tenChuDe}</form:option>
                        </c:forEach>
                    </form:select><br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-1"></label>
                <div class="col-md-10">
                    <input type="submit" value="Cập nhật" class="btn btn-primary"/>
                    &nbsp;
                    <a href="${urlList}" class="btn btn-dark">Trở lại</a>
                </div>
            </div>
        </div>
    </fieldset>
</form:form>
</body>
</html>
