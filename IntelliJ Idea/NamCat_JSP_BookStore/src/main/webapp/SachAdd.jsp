<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/6/2024
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="vn.com.stanford.bst.model.*,vn.com.stanford.bst.entities.*" %>
<html>
<head>
    <title>Thêm hoặc sửa sách</title>
</head>
<%
    //Declare variables
    String sachId = "", maSach = "", tenSach = "", moTa = "", anhSach = "", tacGia = "";
    int giaSach = 0;

    if(request.getParameter("id") != null)
    {
        //Get book code
        sachId = request.getParameter("id");

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
                    <td></td>
                    <td>
                        <input type="submit" value="Cập nhật" name="btnCapNhat"> &nbsp; <a href="QuanLySach.jsp">Trở lại</a>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
