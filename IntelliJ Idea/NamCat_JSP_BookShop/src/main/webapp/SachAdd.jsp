<%@ page import="vn.com.namcat.bookshop.model.*" %>
<%@ page import="vn.com.namcat.bookshop.entities.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Dell Precision 7550
  Date: 10/14/2024
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm hoặc sửa sách</title>
</head>
<%
    //Declare variables
    String sachId = "", maSach = "", tenSach = "", moTa = "", anhSach = "", tacGia = "", maChuDe = "";
    int giaSach = 0;

    //Declare an object to use functions
    ChuDeDao chuDeDao = new ChuDeImpl();

    //Declare ChuDe list
    List<ChuDe> lstChuDe = new ArrayList<ChuDe>();

    //Get ChuDe list
    lstChuDe = chuDeDao.layDanhSach();

    //Check if the id is null
    if(request.getParameter("id") != null)
    {
        //Get book code
        sachId = "" + request.getParameter("id");

        //Declare an object to use functions
        SachDao sachDao = new SachImpl();

        //Get book object from book code
        Sach objSach = sachDao.layChiTiet(sachId);

        if(objSach != null)
        {
            //Assign values to variables
            maSach = objSach.getMaSach();
            tenSach = objSach.getTenSach();
            moTa = objSach.getMoTa();
            anhSach = objSach.getAnhSach();
            tacGia = objSach.getTacGia();
            giaSach = objSach.getGiaSach();
            maChuDe = objSach.getMaChuDe();
        }
    }
%>
<body>
    <div style="text-align: center">
        <h2 style="text-transform: uppercase">Thêm, sửa thông tin sách</h2>
    </div>
    <form method="post" action="SachServlet">
        <fieldset>
            <legend>Nhập thông tin sách</legend>
            <table>
                <tr>
                    <td>Mã sách</td>
                    <td>
                        <input type="text" name="txtMaSach" value="<%=maSach%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Tên sách</td>
                    <td>
                        <input type="text" name="txtTenSach" value="<%=tenSach%>"/>
                        <input type="hidden" name="hSachId" value="<%=sachId%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Mô tả</td>
                    <td>
                        <textarea name="txtMoTa" rows="5"><%=moTa%></textarea>
                    </td>
                </tr>
                <tr>
                    <td>Ảnh sách: </td>
                    <td>
                        <input type="text" name="txtAnhSach" value="<%=anhSach%>"/>
                        <input type="file"/>
                    </td>
                </tr>
                <tr>
                    <td>Giá sách: </td>
                    <td>
                        <input type="text" name="txtGiaSach" value="<%=giaSach%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Tác giả: </td>
                    <td>
                        <input type="text" name="txtTacGia" value="<%=tacGia%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Chủ đề: </td>
                    <td>
                        <select name="cboChuDe">
                            <option value="">Chọn chủ đề</option>
                            <c:set var="maCD" value="<%=maChuDe%>"/>
                            <c:forEach var="c" items="<%=lstChuDe%>">
                                <c:if test="${c.maChuDe == maCD}">
                                    <option value="${c.maChuDe}" selected="selected">${c.tenChuDe}</option>
                                </c:if>
                                <c:if test="${c.maChuDe != maCD}">
                                    <option value="${c.maChuDe}">${c.tenChuDe}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Cập nhật" name="btnCapNhat">
                        &nbsp;
                        <a href="QuanLySach.jsp">Trở lại</a>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
