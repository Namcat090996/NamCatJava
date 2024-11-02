<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/1/2024
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix ="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Thêm mới hoặc sửa thông tin nhân viên</title>
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
<c:url value="/admin/nhanvien/themMoiNV" var="urlInsert"/>
<c:url value="/admin/nhanvien" var="urlList"/>
<form:form method="post" action="${urlInsert}" modelAttribute="nhanvien" acceptCharset="utf-8">
    <fieldset>
        <legend>Nhập thông tin nhân viên</legend>
        <div class="container-fluid">
            <div class="row">
                <label class="col-md-2">Mã nhân viên:</label>
                <div class="col-md-4">
                    <form:input path="maNV" cssClass="form-control"/><br>
                    <form:errors path="maNV" cssClass="errorfinfo"/>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Họ tên:</label>
                <div class="col-md-6">
                    <form:input path="hoTen" cssClass="form-control"/><br>
                    <form:errors path="hoTen" cssClass="errorfinfo"/>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Giới tính:</label>
                <div class="col-md-6">
                    <form:radiobutton path="gioiTinh" value="0"/>&nbsp;Nam &nbsp;
                    <form:radiobutton path="gioiTinh" value="1"/>&nbsp;Nữ
                    <br>
                    <br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Ngày sinh:</label>
                <div class="col-md-6">
                    <form:input type="text" path="ngaySinh" cssClass="form-control" placeholder="dd/MM/yyyy"/><br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Điện thoại:</label>
                <div  class="col-md-6">
                    <form:input path="dienThoai" cssClass="form-control"/><br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Email:</label>
                <div  class="col-md-6">
                    <form:input path="email" cssClass="form-control"/><br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Địa chỉ:</label>
                <div  class="col-md-6">
                    <form:input path="diaChi" cssClass="form-control"/><br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Số CMT:</label>
                <div  class="col-md-6">
                    <form:input path="soCMT" cssClass="form-control"/><br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Ngày cấp:</label>
                <div  class="col-md-6">
                    <form:input type="text" path="ngayCap" cssClass="form-control" placeholder="dd/MM/yyyy"/><br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Nơi cấp:</label>
                <div  class="col-md-6">
                    <form:input path="noiCap" cssClass="form-control"/><br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Chức vụ:</label>
                <div class="col-md-6">
                    <form:select path="maChucVu" cssClass="form-control">
                        <form:option value="">--- Chọn chức vụ ---</form:option>
                        <c:forEach var="cv" items="${chucVuList}">
                            <form:option value="${cv.maChucVu}">${cv.tenChucVu}</form:option>
                        </c:forEach>
                    </form:select><br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Phòng ban:</label>
                <div class="col-md-6">
                    <form:select path="maPhong" cssClass="form-control">
                        <form:option value="">--- Chọn phòng ban ---</form:option>
                        <c:forEach var="pb" items="${phongBanList}">
                            <form:option value="${pb.maPhong}">${pb.tenPhong}</form:option>
                        </c:forEach>
                    </form:select><br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-2">Hệ số lương:</label>
                <div class="col-md-6">
                    <form:select path="heSoId" cssClass="form-control">
                        <form:option value="0">--- Chọn hệ số ---</form:option>
                        <c:forEach var="hs" items="${heSoLuongList}">
                            <form:option value="${hs.id}">${hs.heSo}</form:option>
                        </c:forEach>
                    </form:select><br>
                </div>
            </div>
            <div class="row">
                <label class="col-md-1"></label>
                <div  class="col-md-6">
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
