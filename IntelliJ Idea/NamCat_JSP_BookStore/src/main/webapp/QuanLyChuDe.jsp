<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/8/2024
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList,java.util.List,vn.com.stanford.bst.model.*,vn.com.stanford.bst.entities.*" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý chủ đề sách</title>
    <script>
        function confirmDelete()
        {
            return confirm("Bạn có chắc chắn muốn xóa không ?");
        }
    </script>
</head>
<%
    //Declare an object to get a list using a function
    ChuDeDao chuDeDao = new ChuDeImpl();

    //Get the subject list
    List<ChuDe> lstChuDe = chuDeDao.layDanhSach();
%>
<body>
<div style="text-align: center">
    <h2 style="text-transform: uppercase">Quản lý thông tin sách</h2>
</div>
<div>
    <table border="1" style="border-collapse: collapse; width: 500px; margin-left: auto; margin-right: auto;">
        <tr>
            <th>Mã chủ đề</th>
            <th>Tên chủ đề</th>
            <th><a href="ChuDeAdd.jsp">Thêm mới</a></th>
        </tr>
        <tbody>
        <c:forEach var="c" items="<%=lstChuDe%>">
            <tr>
                <td style="text-align: center">${c.maChuDe}</td>
                <td style="text-align: center">${c.tenChuDe}</td>
                <td style="text-align: center">
                    <a href="ChuDeAdd.jsp?id=${c.maChuDe}" title="Nhấn vào đây để sửa thông tin">Sửa</a>
                    &nbsp;
                    <a href="ChuDeServletXoa?id=${c.maChuDe}" title="Nhấn vào đây để xóa thông tin" onclick="return confirmDelete()">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
