<%@ page import="vn.com.stanford.je082401.amthuc.entities.MonAn" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.com.stanford.je082401.amthuc.model.MonAnDao" %>
<%@ page import="vn.com.stanford.je082401.amthuc.model.MonAnImpl" %>
<%@ page import="vn.com.stanford.je082401.amthuc.entities.ChuDe" %>
<%@ page import="vn.com.stanford.je082401.amthuc.model.ChuDeDao" %>
<%@ page import="vn.com.stanford.je082401.amthuc.model.ChuDeImpl" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/18/2024
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //Khai báo danh sách
    List<ChuDe> lstChuDe = new ArrayList<>();

    ChuDeDao chuDeDao = new ChuDeImpl() {
    };

    //Lâý danh sách
    lstChuDe = chuDeDao.layDanhSach();
%>
<div id="sidebar1">
    <h2 class="subhead">Categories</h2>
    <ul class="menu">
        <c:forEach var="c" items="<%=lstChuDe%>">
            <li><a href="#">${c.tenChuDe}</a></li>
        </c:forEach>
    </ul>
</div>
