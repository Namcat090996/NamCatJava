<%@ page import="vn.com.stanford.je082401.amthuc.model.MonAnDao" %>
<%@ page import="vn.com.stanford.je082401.amthuc.model.MonAnImpl" %>
<%@ page import="vn.com.stanford.je082401.amthuc.entities.MonAn" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/18/2024
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Stanford - Dạy kinh nghiệm lập trình</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery-1.4.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/loopedslider.js" type="text/javascript" charset="utf-8"></script>
</head>
<%
    //Lấy danh sách sách
    MonAnDao monAnDao = new MonAnImpl();

    List<MonAn> lstMonAn = monAnDao.layDanhSach();
%>
<body>
    <jsp:include page="home/topbanner.jsp"/>
    <div id="wrap">
        <jsp:include page="home/header.jsp"/>
        <jsp:include page="home/menu.jsp"/>
        <jsp:include page="home/submenu.jsp"/>
        <div id="content">
            <jsp:include page="home/sidebar.jsp"/>
                <c:forEach var="c" items="<%=lstMonAn%>">
                    <div id="maincontent">
                        <h2>${c.chuDe}</h2>
                        <h3><a href="ThongTinMonAn.jsp?ma=${c.tenMonAn}">${c.tenMonAn}</a></h3>
                        <a href="ThongTinMonAn.jsp?ma=${c.tenMonAn}"><img src="images/${c.anhMonAn}" width="250" height="150" alt="imag" class="leftalign"/></a>
                        <p>${c.moTa}</p>
                        <p>${c.noiDung}</p>
                    </div>
                </c:forEach>
            <div class="clear"></div>
        </div>
        <jsp:include page="home/footer.jsp"/>
    </div>
    <script type="text/javascript" charset="utf-8">
        $(function(){
            $('#slider').loopedSlider({
                autoStart: 2500,
                restart: 5000
            });
    
        });
    </script>
</body>
</html>
