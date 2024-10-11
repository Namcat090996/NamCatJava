<%@ page import="java.util.List" %>
<%@ page import="vn.com.stanford.je0824.bookstore.entities.Sach" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Dell Precision 7550
  Date: 10/11/2024
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ hàng của bạn</title>
</head>
<%
List<Sach> lstSach = new ArrayList<Sach>();

if(session.getAttribute("gioHang") != null)
{
    lstSach = (List<Sach>) session.getAttribute("gioHang");
}
%>
<body>
<div style="width:100%; text-align:center;">
    <h2 style="text-transform: uppercase;">Giỏ hàng của bạn</h2>
</div>

<table border="1" style="width:100%; border-collapse:collapse;">
    <tr>
        <th>
            Ảnh sách
        </th>
        <th>
            Id
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
            Số lượng
        </th>
    </tr>
    <tbody>
    <c:forEach var="s" items="<%=lstSach%>">
        <tr>
            <td>
                <img src="images/${s.anhSach}" width="100" height="120" /></td>
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
