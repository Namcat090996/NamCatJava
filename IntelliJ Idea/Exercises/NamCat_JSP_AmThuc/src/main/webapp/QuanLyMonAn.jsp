<%@ page import="vn.com.stanford.je082401.amthuc.model.MonAnDao" %>
<%@ page import="vn.com.stanford.je082401.amthuc.model.MonAnImpl" %>
<%@ page import="vn.com.stanford.je082401.amthuc.entities.MonAn" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/18/2024
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý thông tin món ăn</title>
</head>
<%
    //Lấy danh sách món ăn
    MonAnDao monAnDao = new MonAnImpl();

    List<MonAn> lstMonAn = new ArrayList<MonAn>();

    lstMonAn = monAnDao.layDanhSach();
%>
<body>
<div style="width: 100%; text-align: right">
    <a href="MonAnAdd.jsp">Thêm mới</a>
</div>
<table border="1" style="width:100%; border-collapse:collapse;">
    <tr>
        <th>
            Tên món ăn
        </th>
        <th>
            Mô tả
        </th>
        <th>
            Nội dung
        </th>
        <th>
            Ngày tạo
        </th>
        <th>
            Ngày cập nhật
        </th>
        <th>
            Ảnh món ăn
        </th>
        <th>
            Chủ đề món ăn
        </th>
        <th>
        </th>
    </tr>
    <tbody>
    <c:forEach var="c" items="<%=lstMonAn%>">
        <tr>
            <td>${c.tenMonAn}</td>
            <td>${c.moTa}</td>
            <td>${c.noiDung}</td>
            <td>${c.ngayTao}</td>
            <td>${c.ngayCapNhat}</td>
            <td>${c.anhMonAn}</td>
            <td>${c.chuDe}</td>
            <td>
                <a href="MonAnAdd.jsp?id=${c.tenMonAn}" title="Nhấn vào đây để sửa thông tin">Sửa</a>
                &nbsp;
                <a href="MonAnServlet?id=${c.tenMonAn}" onclick="return confirm('Bạn có chắc chắn muốn xóa không ?')" title="Nhấn vào đây để xóa thông tin">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
