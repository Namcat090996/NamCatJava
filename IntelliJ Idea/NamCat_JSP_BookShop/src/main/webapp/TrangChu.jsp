<%@ page import="vn.com.namcat.bookshop.model.*" %>
<%@ page import="vn.com.namcat.bookshop.entities.*" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/14/2024
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang Chủ - BookStore</title>
    <link rel="stylesheet" type="text/css" href="css/templatemo_style.css"/>
</head>
<body>
<%
    //Ser utf-8 for request
    request.setCharacterEncoding("utf-8");

    //Declare variables
    String maCD = "";

    //Check if the parameter of request is null
    if(request.getParameter("ma") != null)
    {
        maCD = "" + request.getParameter("ma");
    }

    //Declare an object to call the function
    SachDao sachDao = new SachImpl();

    //Get the book list
    List<Sach> lstSach = sachDao.timKiemSach("", maCD);
%>
<!-- Templates from www.stanford.com.vn -->
<div id="templatemo_container">

    <jsp:include page="home/menu.jsp"/>
    <jsp:include page="home/header.jsp"/>

    <div id="templatemo_content">
        <div id="templatemo_content_left">
            <jsp:include page="home/sidebar.jsp"/>
        </div> <!-- end of content left -->

        <div id="templatemo_content_right">
            <c:forEach var="s" items="<%=lstSach %>" varStatus="i">
                <div class="templatemo_product_box">
                    <h1>${s.tenSach} <span>(by ${s.tacGia})</span></h1>
                    <img src="images/${s.anhSach}" width="100" height="150" alt="image"/>
                    <div class="product_info">
                        <p>${s.moTa}</p>
                        <h3>${s.giaSach}</h3>
                        <div class="buy_now_button">
                            <a href="GioHangServlet?id=${s.maSach}">Mua ngay</a>
                        </div>
                        <div class="detail_button"><a href="ChiTiet.jsp?id=${s.maSach}">Chi tiết</a></div>
                    </div>
                    <div class="cleaner">&nbsp;</div>
                </div>
                <c:if test="${i.index%2==0}">
                    <div class="cleaner_with_width">&nbsp;</div>
                </c:if>
                <c:if test="${i.index%2!=0}">
                    <div class="cleaner_with_height">&nbsp;</div>
                </c:if>
            </c:forEach>
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
