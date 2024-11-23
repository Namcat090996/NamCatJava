<%--
  Created by IntelliJ IDEA.
  User: Dell Precision 7550
  Date: 10/31/2024
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix ="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Staff information management</title>
    <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css"/>'>
    <script type="text/javascript" src='<c:url value="/resources/js/jquery-3.7.1.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/bootstrap.js"/>'></script>
    <style type="text/css">
        .custom-width {
            padding-left: 10px;
            padding-right: 0px;
        }

        .input {
            padding-left: 0px;
        }

        .search {
            transition: background-color 1s ease;
            position: relative;
            left: 40px;
        }

        .search:hover {
            background-color: #0d6efd;
        }

        .legend {
            position: relative;
            left: 15px;
            bottom: 5px;
        }

    </style>
</head>
<body>
    <c:url value="/admin/nhanvien/them" var="urlSave"/>
    <c:url value="/admin/nhanvien/sua" var="urlUpdate"/>
    <c:url value="/admin/nhanvien/xoa" var="urlDelete"/>
    <c:url value="/admin/nhanvien" var="urlSearch"/>
    <c:if test="${not empty error_message}">
        <script>
            alert("${error_message}");
        </script>
    </c:if>
    <div style="text-align: center; position: relative; top: 10px; color: orangered">
        <h2>Staff information management</h2>
    </div>
    <form:form action="${urlSearch}" modelAttribute="nhanvien" acceptCharset="utf-8">
        <fieldset>
            <legend class="legend">Nhập thông tin để tìm kiếm</legend>
            <div class="row">
                <label class="custom-width col-md-1 d-flex align-items-center justify-content-center">Từ khóa:</label>
                <div class="input col-md-2">
                    <form:input path="tuKhoa" cssClass="form-control"/>
                </div>
                <label class="custom-width col-md-1 d-flex align-items-center justify-content-center">Phòng ban:</label>
                <div class="input col-md-2">
                    <form:select path="maPhong" cssClass="form-control">
                        <form:option value="">--- Chọn phòng ban ---</form:option>
                        <c:forEach var="pb" items="${phongBanList}">
                            <form:option value="${pb.maPhong}">${pb.tenPhong}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <label class="custom-width col-md-1 d-flex align-items-center justify-content-center">Chức vụ:</label>
                <div class="input col-md-2">
                    <form:select path="maChucVu" cssClass="form-control">
                        <form:option value="">--- Chọn chức vụ ---</form:option>
                        <c:forEach var="cv" items="${chucVuList}">
                            <form:option value="${cv.maChucVu}">${cv.tenChucVu}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="col-md-2">
                    <input type="submit" value="Tìm kiếm" name="btnTimKiem" class="search btn btn-secondary"/>
                </div>
            </div>
        </fieldset>
    </form:form>
    <div class="container-fluid">
        <div style="width: 100%; text-align: right; padding-bottom: 5px;">
            <a class="btn btn-primary" href="${urlSave}">Thêm mới</a>
        </div>
        <table class="table table-striped table-bordered">
            <tr>
                <th>Mã nhân viên</th>
                <th>Họ tên</th>
                <th>Giới tính</th>
                <th>Ngày sinh</th>
                <th>Điện thoại</th>
                <th>Địa chỉ</th>
                <th>Phòng ban</th>
                <th>Chức vụ</th>
                <th>Lương/tháng</th>
                <th style="width:40px;"></th>
                <th style="width:40px;"></th>
            </tr>
            <c:if test="${not empty lstNhanVien}">
                <c:forEach var="nv" items="${lstNhanVien}">
                    <tr>
                        <td>${nv.maNV}</td>
                        <td>${nv.hoTen}</td>
                        <td>${nv.gioiTinh == 1 ? 'Nữ' : 'Nam'}</td>
                        <td>
                            <fmt:formatDate value="${nv.ngaySinh}" pattern="dd-MM-yyyy"/>
                        </td>
                        <td>${nv.dienThoai}</td>
                        <td>${nv.diaChi}</td>
                        <td>${nv.tenPhong}</td>
                        <td>${nv.tenChucVu}</td>
                        <td>
                            <fmt:formatNumber value="${nv.tongLuong}" pattern="#,##0.###"/>đ
                        </td>
                        <td> <a class="btn btn-primary" href="${urlUpdate}/${nv.maNV}">Sửa</a></td>
                        <td> <a class="btn btn-danger" href="${urlDelete}/${nv.maNV}" onclick="return confirm('Bạn có chắc chắn muốn xóa thông tin này ?');">Xóa</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>
</body>
</html>
