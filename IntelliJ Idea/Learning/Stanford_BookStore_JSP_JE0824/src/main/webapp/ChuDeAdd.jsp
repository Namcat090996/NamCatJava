<%--
  Created by IntelliJ IDEA.
  User: dangb
  Date: 04/10/2024
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List, java.util.ArrayList,vn.com.stanford.je0824.bookstore.model.*,vn.com.stanford.je0824.bookstore.entities.*" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm hoặc sửa sách</title>
</head>
<body>
<%
    //Xử lý hiển thị chi tiết
    String maChuDe = "", tenChuDe = "";

    if(request.getParameter("id") != null)
    {
        maChuDe = "" + request.getParameter("id") ;

        ChuDeDao chuDeDao = new ChuDeImpl();

        //Lấy chi tiêết
        ChuDe objChuDe = chuDeDao.layChiTiet(maChuDe);

        if(objChuDe != null)
        {
            tenChuDe = objChuDe.getTenChuDe();
        }
    }

    //Khai báo danh sách chủ đề
    List<ChuDe> lstChuDe = new ArrayList<ChuDe>();

    ChuDeDao chuDeDao = new ChuDeImpl();

    lstChuDe = chuDeDao.layDanhSach();

%>
<div style="width:100%; text-align:center;">
    <h2 style="text-transform: uppercase;">Thêm, sửa thông tin sách</h2>
</div>

<form method="post" action="ChuDeServlet">
    <fieldset>
        <legend>Nhập thông tin sách</legend>
        <table>
            <tr>
                <td>
                    Mã sách:
                </td>
                <td>
                    <input type="text" name="txtMaChuDe" value="<%=maChuDe%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    Tên sách:
                </td>
                <td>
                    <input type="text" name="txtTenChuDe" value="<%=tenChuDe%>"/>
                    <input type="hidden" name="hChuDeId" value="<%=maChuDe%>"/>
                </td>
            </tr>
            <tr>
                <td>

                </td>
                <td>
                    <input type="submit" name="btnCapNhat" value="Cập nhật"/>
                    &nbsp;
                    <a href="QuanLyChuDe.jsp.jsp">Trở lại</a>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
