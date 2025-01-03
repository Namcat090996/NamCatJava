<%--
  Created by IntelliJ IDEA.
  User: dangb
  Date: 11/10/2024
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="vn.com.stanford.je0824.bookstore.model.*,vn.com.stanford.je0824.bookstore.entities.*" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Đăng nhập hệ thống</title>
    <link rel="stylesheet" type="text/css" href="css/templatemo_style.css"/>
</head>
<body>
<%
    //Khai báo biến
    String taiKhoan = "", matKhau = "", thongBao = "";

    if(request.getParameter("txtTaiKhoan") != null)
    {
        taiKhoan = request.getParameter("txtTaiKhoan");
        matKhau = request.getParameter("txtMatKhau");

        if(taiKhoan.equals("stanford") && matKhau.equals("123"))
        {
            //Lưu vào session
            session = request.getSession(true);

            //Gán giá trị để lưu
            session.setAttribute("userOnline", taiKhoan);

            //Di chuyển sang trang quản trị
            response.sendRedirect("admin/QuanLySach.jsp");
        }
        else
        {
            thongBao = "Tài khoản không chính xác. Bạn vui lòng kiểm tra lại";
        }
    }
%>
<div id="templatemo_container">

    <jsp:include page="home/menu.jsp"/>

    <jsp:include page="home/header.jsp"/>
    <div id="templatemo_content">

        <div id="templatemo_content_left">
            <jsp:include page="home/sidebar.jsp"/>
        </div> <!-- end of content left -->

        <div id="templatemo_content_right">
            <form method="post">
            <h1>Đăng nhập hệ thống</h1>
            <fieldset>
                <legend>Nhập thông tin đăng nhập</legend>
                <table>
                    <tr>
                        <td>Tài khoản:</td>
                        <td>
                            <input type="text" name="txtTaiKhoan" value="<%=taiKhoan%>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Tài khoản:</td>
                        <td>
                            <input type="password" name="txtMatKhau" value="<%=matKhau%>"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" name="btnDangNhap" value="Đăng nhập"/>
                            &nbsp;
                            <a href="TrangChu.jsp">Hủy bỏ</a>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <span style="color:red"><%=thongBao%></span>
                        </td>
                    </tr>
                </table>
            </fieldset>
            </form>
            <a href="#"><img src="images/templatemo_ads.jpg" alt="ads"/></a>
        </div> <!-- end of content right -->

        <div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->

    <jsp:include page="home/footer.jsp"/>
    <!-- end of footer -->
    <!--  Free CSS Template www.templatemo.com -->
</div> <!-- end of container -->
<div align=center>This template downloaded form <a href='https://stanford.com.vn'>Stanford.com.vn</a></div>
</body>
</html>
