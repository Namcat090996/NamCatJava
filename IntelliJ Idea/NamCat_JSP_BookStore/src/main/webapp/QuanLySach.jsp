<%--
  Created by IntelliJ IDEA.
  User: Dell Precision 7550
  Date: 10/6/2024
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList,java.util.List,vn.com.stanford.bst.model.*,vn.com.stanford.bst.entities.*" %>
<!--  Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý thông tin sách</title>
</head>
<%
    //Set utf-8 for request
    request.setCharacterEncoding("utf-8");

    //Declare variables
    String tuKhoa = "", maChuDe = "";

    //Get data from input if it's not null
    if(request.getParameter("txtTuKhoa") != null)
    {
        tuKhoa = "" + request.getParameter("txtTuKhoa");
    }

    if(request.getParameter("cboChuDe") != null)
    {
        maChuDe = "" + request.getParameter("cboChuDe");
    }

    //Declare object to get book list using function
    SachDao sachDao = new SachImpl();

    //Get book list from keyword and subject
    List<Sach> lstSach = sachDao.timKiemSach(tuKhoa, maChuDe);

    //Declare object to get subject list using function
    ChuDeDao chuDe = new ChuDeImpl();

    //Declare subject list
    List<ChuDe> lstChuDe = new ArrayList<ChuDe>();

    //Get subject list
    lstChuDe = chuDe.layDanhSach();
%>
<body>
<%@include file="admin/header.jsp" %>
<%@include file="admin/menu.jsp" %>
<div style="text-align:center;">
    <h2 style="text-transform: uppercase;">Quản lý thông tin sách</h2>
</div>
<div style="text-align: right">
    <a href="SachAdd.jsp">Thêm mới</a>
</div>
<form method="post">
<fieldset>
    <legend>Nhập thông tin tìm kiếm</legend>
    <table>
        <tr>
            <td>Từ khóa: </td>
            <td>
                <input type="text" name="txtTuKhoa" value="<%=tuKhoa%>">
            </td>
            &nbsp;
            <td>Chủ đề: </td>
            <td>
                <select name="cboChuDe">
                    <option value="">Chọn chủ đề</option>
                    <c:set var="MaChuDe" value="<%=maChuDe%>"/>
                    <c:forEach var="c" items="<%=lstChuDe%>">
                        <c:if test="${c.maChuDe == MaChuDe}">
                            <option value="${c.maChuDe}" selected="selected">${c.tenChuDe}</option>
                        </c:if>
                        <c:if test="${c.maChuDe != MaChuDe}">
                            <option value="${c.maChuDe}">${c.tenChuDe}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            &nbsp;
            <td>
                <input type="submit" name="btnTimKiem" value="Tìm kiếm">
            </td>
        </tr>
    </table>
</fieldset>
</form>
<table border="1" style="width:100%; border-collapse:collapse;">
    <tr>
        <th>
            Ảnh sách
        </th>
        <th>
            Mã sách
        </th>
        <th>
            Tên sách
        </th>
        <th>
            Mô tả
        </th>
        <th>
            Giá sách
        </th>
        <th>
            Tác giả
        </th>
        <th>
        </th>
    </tr>
    <tbody>
    <c:forEach var="s" items="<%=lstSach %>">
        <tr>
            <td>
                <img src="images/${s.anhSach}" width="100" height="120" alt="book store"/> </td>
            <td>${s.maSach}</td>
            <td>${s.tenSach}</td>
            <td>${s.moTa}</td>
            <td>${s.giaSach}</td>
            <td>${s.tacGia}</td>
            <td>
                <a href="SachAdd.jsp?id=${s.maSach}" title="Nhấn vào đây để sửa thông tin">Sửa</a>
                &nbsp;
                <a href="SachServlet?id=${s.maSach}" title="Nhấn vào đây để xóa thông tin" onclick="return confirm('Bạn có chắc chắn muốn xóa không ???')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="admin/footer.jsp" %>
</body>
</html>
