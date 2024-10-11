<%@ page import="vn.com.stanford.je0824.bookstore.model.ChuDeImpl" %>
<%@ page import="vn.com.stanford.je0824.bookstore.entities.ChuDe" %>
<%@ page import="vn.com.stanford.je0824.bookstore.model.ChuDeDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dangb
  Date: 09/10/2024
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //Khai báo danh sách chủ đề
    List<ChuDe> lstChuDe = new ArrayList<ChuDe>();

    ChuDeDao chuDeDao = new ChuDeImpl();

    lstChuDe = chuDeDao.layDanhSach();
%>
<div class="templatemo_content_left_section">
    <h1>Danh mục sách</h1>
    <ul>
        <c:forEach var="c" items="<%=lstChuDe%>">
            <li value="${c.maChuDe}"><a href="?id=${c.maChuDe}">${c.tenChuDe}</a></li>
        </c:forEach>
    </ul>
</div>

<div class="templatemo_content_left_section">
    <a href="http://validator.w3.org/check?uri=referer">
        <img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0"/>
    </a>
    <a href="http://jigsaw.w3.org/css-validator/check/referer">
        <img style="border:0;width:88px;height:31px" src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0"/>
    </a>
</div>
