<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/23/2024
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix ="form"%>
<html>
<head>
    <title>Đăng nhập hệ thống</title>
</head>
<body>
<form method="post" action="thucHienDangNhap">
    <fieldset>
        <legend>Nhập thông tin đăng nhập</legend>
        <table>
            <tr>
                <td>Tên đăng nhập:</td>
                <td>
                    <input type="text" name="tenDangNhap">
                </td>
            </tr>
            <tr>
                <td>Mật khẩu:</td>
                <td>
                    <input type="password" name="matKhau">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Đăng nhập"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    Bạn vừa nhập thông tin với:<br>
                    Tên đăng nhập: ${tenDangNhap}<br>
                    Mật khẩu: ${matKhau}
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
