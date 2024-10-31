<%@ page import="vn.com.namcat.bookshop.model.*" %>
<%@ page import="vn.com.namcat.bookshop.entities.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/14/2024
  Time: 7:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý thông tin sách</title>
</head>
<%
    //Set utf-8 for request
    request.setCharacterEncoding("utf-8");

    //Declare variables
    String maChuDe = "", tuKhoa = "";

    if(request.getParameter("txtTuKhoa") != null)
    {
        tuKhoa = request.getParameter("txtTuKhoa");
    }

    if(request.getParameter("cboChuDe") != null)
    {
        maChuDe = request.getParameter("cboChuDe");
    }

    //Declare an object to use functions
    ChuDeDao chuDeDao = new ChuDeImpl();
    SachDao sachDao = new SachImpl();

    //Declare a list
    List<ChuDe> lstChuDe = new ArrayList<ChuDe>();
    List<Sach> lstSach = new ArrayList<Sach>();

    //Get list
    lstChuDe = chuDeDao.layDanhSach();
    lstSach = sachDao.timKiemSach(tuKhoa, maChuDe);
%>
<body>
    <div style="text-align: center; padding-top: 5px">
        <h2 style="text-transform: uppercase">Quản lý thông tin sách</h2>
    </div>
    <form method="post">
        <fieldset>
            <legend>Nhập thông tin tìm kiếm</legend>
            <table>
                <tr>
                    <td>Từ khóa: </td>
                    <td>
                        <input type="text" name="txtTuKhoa" value="<%=tuKhoa%>"/>
                    </td>
                    <td>&nbsp;Chủ đề: </td>
                    <td>
                        <select name="cboChuDe">
                            <option value="">Chọn chủ đề</option>
                            <c:set var="maCD" value="<%=maChuDe%>"/>
                            <c:forEach var="c" items="<%=lstChuDe %>">
                                <c:if test="${c.maChuDe==maCD}">
                                    <option value="${c.maChuDe}" selected="selected">${c.tenChuDe}</option>
                                </c:if>
                                <c:if test="${c.maChuDe!=maCD}">
                                    <option value="${c.maChuDe}">${c.tenChuDe}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        &nbsp;<input type="submit" name="btnTimKiem" value="Tìm kiếm"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
    <div style="text-align: right">
        <a href="SachAdd.jsp">Thêm mới</a>
    </div>
    <table border="1" style="border-collapse: collapse; width: 100%">
        <tr>
            <th>Ảnh sách</th>
            <th>Mã sách</th>
            <th>Tên sách</th>
            <th>Mô tả</th>
            <th>Giá sách</th>
            <th>Tác giả</th>
            <th></th>
        </tr>
        <tbody>
        <c:forEach var="s" items="<%=lstSach%>">
            <tr>
                <td>
                    <img src="images/${s.anhSach}" width="100" height="120" alt="Book_List"/>
                </td>
                <td>${s.maSach}</td>
                <td>${s.tenSach}</td>
                <td>${s.moTa}</td>
                <td>${s.giaSach}</td>
                <td>${s.tacGia}</td>
                <td>
                    <a href="SachAdd.jsp?id=${s.maSach}" title="Nhấn vào đây để sửa thông tin">Sửa</a>
                    &nbsp;
                    <a href="SachServlet?id=${s.maSach}" title="Nhấn vào đây để xóa thông tin" onclick="return confirm('Bạn có chắc chắn muốn xóa không ?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
