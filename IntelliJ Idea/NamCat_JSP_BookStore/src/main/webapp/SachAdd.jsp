<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/6/2024
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="vn.com.stanford.bst.model.*,vn.com.stanford.bst.entities.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Thêm hoặc sửa sách</title>
</head>
<%
    //Declare variables
    String sachId = "", maSach = "", tenSach = "", moTa = "", anhSach = "", tacGia = "", maChuDe = "";
    int giaSach = 0;

    //Declare object to get subject list using function
    ChuDeDao chuDe = new ChuDeImpl();

    //Declare subject list
    List<ChuDe> lstChuDe = new ArrayList<ChuDe>();

    //Get subject list
    lstChuDe = chuDe.layDanhSach();

    if(request.getParameter("id") != null)
    {
        //Get book code
        sachId = "" + request.getParameter("id");

        //Declare object
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
                    <td>
                        Ảnh sách:
                    </td>
                    <td>
                        <input type="text" name="txtAnhSach" value="<%=anhSach%>"/>
                        <input type="file"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Giá sách:
                    </td>
                    <td>
                        <input type="text" name="txtGiaSach" value="<%=giaSach%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Tác giả:
                    </td>
                    <td>
                        <input type="text" name="txtTacGia" value="<%=tacGia%>"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Chủ đề:
                    </td>
                    <td>
                        <select name="cboChuDe">
                            <c:forEach var="c" items="<%=lstChuDe%>">
                                <option value="${c.maChuDe}" name="slChuDe">${c.tenChuDe}</option>
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
