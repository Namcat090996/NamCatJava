<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/14/2024
  Time: 7:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý thông tin sách</title>
</head>
<%

%>
<body>
    <div style="text-align: center">
        <h2 style="text-transform: uppercase">Quản lý thông tin sách</h2>
    </div>
    <form>
        <fieldset>
            <legend>Nhập thông tin tìm kiếm</legend>
            <table>
                <tr>
                    <td>Từ khóa: </td>
                    <td>
                        <input type="text" value="txtTuKhoa"/>
                    </td>
                    &nbsp;
                    <td>Chủ đề: </td>
                    <td>
                        <select name="cboChuDe">
                            <c:forEach var="c" items="">
                                <option></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
