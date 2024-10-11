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
    String maChuDe = "", tenChuDe = "";

    //Lấy danh sách sách
    ChuDeDao chuDeDao = new ChuDeImpl();

    List<ChuDe> lstChuDe = chuDeDao.layDanhSach();

%>
<body>
<%@include file="admin/header.jsp" %>
<%@include file="admin/menu.jsp" %>
<div style="width:100%; text-align:center;">
    <h2 style="text-transform: uppercase;">Quản lý thông tin sách</h2>
</div>
<div style="width: 100%; text-align: right">
    <a href="ChuDeAdd.jsp">Thêm mới</a>
</div>
<table border="1" style="width:100%; border-collapse:collapse;">
    <tr>
        <th>
            Ảnh sách
        </th>
        <th>
            Mã sách
        </th>
        <th>
            Tên sách
        </th>
        <th>
            Mô tả
        </th>
        <th>
            Giá sách
        </th>
        <th>
            Tác giả
        </th>
        <th>
        </th>
    </tr>
    <tbody>
    <c:forEach var="s" items="<%=lstChuDe %>">
        <tr>
            <td>${s.maChuDe}</td>
            <td>${s.tenChuDe}</td>
            <td>
                <a href="ChuDeAdd.jsp?id=${s.maChuDe}" title="Nhấn vào đây để sửa thông tin">Sửa</a>
                &nbsp;
                <a href="ChuDeServlet?id=${s.maChuDe}" onclick="return confirm('Bạn có chắc chắn muốn xóa không ?')" title="Nhấn vào đây để xóa thông tin">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="admin/footer.jsp" %>
</body>
</html>
