<%--
  Created by IntelliJ IDEA.
  User: dangb
  Date: 04/10/2024
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList,java.util.List,vn.com.stanford.je0824.bookstore.model.*,vn.com.stanford.je0824.bookstore.entities.*" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý thông tin chủ đề</title>
</head>
<%
    //Khai báo danh sách chủ đề
    List<NhanVienModel> lstNhanVien = new ArrayList<NhanVienModel>();

    NhanVienDao nhanVienDao = new NhanVienImpl();

    lstNhanVien = nhanVienDao.layBangLuongNhanVien();
%>
<body>
<%@include file="header.jsp" %>
<%@include file="menu.jsp" %>
<div style="width:100%; text-align:center;">
    <h2 style="text-transform: uppercase;">Bảng lương nhân viên</h2>
</div>
<form method="post">

</form>

<table border="1" style="width:100%; border-collapse:collapse;">
    <tr>
        <th>
            Mã NV
        </th>
        <th>
            Họ tên
        </th>
        <th>
            Điện thoại
        </th>
        <th>
            Email
        </th>
        <th>
            Địa chỉ
        </th>
        <th>
            Chức vụ
        </th>
        <th>
            Phòng
        </th>
        <th>
            Tổng lương
        </th>

    </tr>
    <tbody>
    <c:forEach var="e" items="<%=lstNhanVien %>">
        <tr>
            <td>${e.maNV}</td>
            <td>${e.hoTen}</td>
            <td>${e.dienThoai}</td>
            <td>${e.email}</td>
            <td>${e.diaChi}</td>
            <td>${e.tenChucVu}</td>
            <td>${e.tenPhong}</td>
            <td>${e.tongLuong}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="footer.jsp" %>
</body>
</html>
