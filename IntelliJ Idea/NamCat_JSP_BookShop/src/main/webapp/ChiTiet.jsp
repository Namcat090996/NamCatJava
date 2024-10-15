<%@ page import="vn.com.namcat.bookshop.entities.*" %>
<%@ page import="vn.com.namcat.bookshop.model.SachDao" %>
<%@ page import="vn.com.namcat.bookshop.model.SachImpl" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/14/2024
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thông tin chi tiết về sách</title>
    <link rel="stylesheet" type="text/css" href="css/templatemo_style.css"/>
</head>
<body>
<%
    //Declare a book object
    Sach objSach = null;

    //Check if the parameter of reuqest is null
    if(request.getParameter("id") != null) {

        //Get book code
        String maSach = "" + request.getParameter("id");

        //Declare an object to call the functions
        SachDao sachDao = new SachImpl();

        //Get a book object
        objSach = sachDao.layChiTiet(maSach);
    }
%>
<c:set var="s" value="<%=objSach%>"/>
<div id="templatemo_container">

    <jsp:include page="home/menu.jsp"/>

    <jsp:include page="home/header.jsp"/>
    <div id="templatemo_content">

        <div id="templatemo_content_left">
            <jsp:include page="home/sidebar.jsp"/>
        </div> <!-- end of content left -->

        <div id="templatemo_content_right">
            <h1><c:out value="${s.tenSach}"/> </h1>
            <h2><c:out value="${s.moTa}"/></h2>
            <p style="width: 100%;text-align: right">
                Tác giả: <span style="font-weight: bold; font-size: 16px"><c:out value="${s.tacGia}"/></span>
            </p>
            <p style="width: 100%;text-align: center">
                <img src='images/<c:out value="${s.anhSach}"/>' width="300"/>
            </p>
            <p style="width: 100%;text-align: right">
                Giá sách: <span style="color:red"><c:out value="${s.giaSach}"/></span>
            </p>
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
