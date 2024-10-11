<%@ page import="java.util.List" %>
<%@ page import="vn.com.stanford.je0824.bookstore.entities.ChuDe" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.com.stanford.je0824.bookstore.model.ChuDeDao" %>
<%@ page import="vn.com.stanford.je0824.bookstore.model.ChuDeImpl" %><%--
  Created by IntelliJ IDEA.
  User: dangb
  Date: 09/10/2024
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //Khai báo danh sách
    List<ChuDe> lstChuDe = new ArrayList<ChuDe>();

    ChuDeDao chuDeDao = new ChuDeImpl();

    lstChuDe = chuDeDao.layDanhSach();
%>
<div class="templatemo_content_left_section">
    <h1>Danh mục sách</h1>
    <ul>
        <c:forEach var="c" items="<%=lstChuDe%>">
            <li value="${c.maChuDe}"><a href="?ma=${c.maChuDe}" title="Lọc sách theo chủ đề">${c.tenChuDe}</a></li>
        </c:forEach>
    </ul>
</div>
<div class="templatemo_content_left_section">
    <h1>Sách bán chạy</h1>
    <ul>
        <li><a href="#">Vestibulum ullamcorper</a></li>
        <li><a href="#">Maece nas metus</a></li>
        <li><a href="#">In sed risus ac feli</a></li>
        <li><a href="#">Praesent mattis varius</a></li>
        <li><a href="#">Maece nas metus</a></li>
        <li><a href="#">In sed risus ac feli</a></li>
    </ul>
</div>

<div class="templatemo_content_left_section">
    <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
    <a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
</div>
