<%--
  Created by IntelliJ IDEA.
  User: Dell Precision 7550
  Date: 10/6/2024
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList,java.util.List,vn.com.stanford.bst.model.*,vn.com.stanford.bst.entities.*" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý thông tin sách</title>
    <script type="text/javascript">
        function confirmDelete()
        {
            return confirm("Bạn có chắc cắn muốn xóa không ?")
        }
    </script>
</head>
<%
    //Lấy danh sách sách
    SachDao sachDao = new SachImpl();

    List<Sach> lstSach = sachDao.layDanhSach();
%>
<body>
<%@include file="admin/header.jsp" %>
<%@include file="admin/menu.jsp" %>
<div style="width:100%; text-align:center;">
    <h2 style="text-transform: uppercase;">Quản lý thông tin sách</h2>
</div>
<div style="width: 100%; text-align: right">
    <a href="SachAdd.jsp">Thêm mới</a>
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
    <c:forEach var="s" items="<%=lstSach %>">
        <tr>
            <td>
                <img src="images/${s.anhSach}" width="100" height="120" alt="book store"/> </td>
            <td>${s.maSach}</td>
            <td>${s.tenSach}</td>
            <td>${s.moTa}</td>
            <td>${s.giaSach}</td>
            <td>${s.tacGia}</td>
            <td>
                <a href="SachAdd.jsp?id=${s.maSach}" title="Nhấn vào đây để sửa thông tin">Sửa</a>
                &nbsp;
                <a href="SachServletXoa?id=${s.maSach}" title="Nhấn vào đây để xóa thông tin" onclick="return confirmDelete();">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="admin/footer.jsp" %>
</body>
</html>
