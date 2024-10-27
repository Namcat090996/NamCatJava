<%--
  Created by IntelliJ IDEA.
  User: Dell Precision 7550
  Date: 10/27/2024
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Declare tag library of Spring MVC --%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>Nhập thông tin đăng nhập</title>
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
                    <input type="submit" value="Đăng nhập" name="btnDangNhap"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    Bạn vừa nhập thông tin là:<br>
                    - Tên đăng nhập: ${tenDangNhap}<br>
                    - Mật khẩu: ${matKhau}
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
