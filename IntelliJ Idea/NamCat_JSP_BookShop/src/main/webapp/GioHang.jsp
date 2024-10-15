<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.com.namcat.bookshop.entities.Sach" %><%--
  Created by IntelliJ IDEA.
  User: Dell Precision 7550
  Date: 10/15/2024
  Time: 7:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Giỏ hàng của bạn</title>
</head>
<%
    //Declare a book list
    List<Sach> lstSach = new ArrayList<Sach>();

    //Check if the attribute session is null
    if(session.getAttribute("gioHang") != null)
    {
        //Get book list from "gioHang" attribute in session
        lstSach = (List<Sach>)session.getAttribute("gioHang");
    }
%>
<body>
<div style="text-align: center">
    <h2 style="text-transform: uppercase">Quản lý giỏ hàng của bạn</h2>
</div>
<table border="1" style="border-collapse: collapse; width: 100%">
    <tr>
        <th>Ảnh sách</th>
        <th>Mã sách</th>
        <th>Tên sách</th>
        <th>Mô tả</th>
        <th>Giá sách</th>
        <th>Tác giả</th>
        <th>Số lượng</th>
    </tr>
    <tbody>
    <c:forEach var="s" items="<%=lstSach%>">
        <tr>
            <td>
                <img src="images/${s.anhSach}" width="100" height="120" alt="Book_List"/>
            </td>
            <td>${s.maSach}</td>
            <td>${s.tenSach}</td>
            <td>${s.moTa}</td>
            <td>${s.giaSach}</td>
            <td>${s.tacGia}</td>
            <td>${s.soLuong}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
