<%@ page import="vn.com.stanford.je082401.amthuc.model.MonAnDao" %>
<%@ page import="vn.com.stanford.je082401.amthuc.model.MonAnImpl" %>
<%@ page import="vn.com.stanford.je082401.amthuc.entities.MonAn" %>
<%@ page import="vn.com.stanford.je082401.amthuc.entities.ChuDe" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.com.stanford.je082401.amthuc.model.ChuDeImpl" %>
<%@ page import="vn.com.stanford.je082401.amthuc.model.ChuDeDao" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/18/2024
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    //Xử lý hiển thị chi tiết
    String monAnId = "", tenMonAn = "", moTa = "", noiDung = "", anhMonAn = "", chuDe = "";
    int giaSach = 0;
    if(request.getParameter("id") != null)
    {
        monAnId = "" + request.getParameter("id");

        MonAnDao monAnDao = new MonAnImpl();
        //Lấy chi tiết
        MonAn objMonAn = monAnDao.layChiTiet(monAnId);

        if(objMonAn != null)
        {
            tenMonAn = objMonAn.getTenMonAn();
            moTa = objMonAn.getMoTa();
            noiDung = objMonAn.getNoiDung();
            anhMonAn = objMonAn.getAnhMonAn();
            chuDe = objMonAn.getChuDe();
        }
    }

    //Khai báo danh sách chủ đề
    List<ChuDe> lstChuDe = new ArrayList<ChuDe>();

    ChuDeDao chuDeDao = new ChuDeImpl();

    lstChuDe = chuDeDao.layDanhSach();
%>
<body>
<div style="width:100%; text-align:center;">
    <h2 style="text-transform: uppercase;">Thêm, sửa thông tin món ăn</h2>
</div>

<form method="post" action="MonAnServlet">
    <fieldset>
        <legend>Nhập thông tin món ăn</legend>
        <table>
            <tr>
                <td>
                    Tên món ăn:
                </td>
                <td>
                    <input type="text" name="txtTenMonAn" value="<%=tenMonAn%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    Mô tả:
                </td>
                <td>
                    <input type="text" name="txtMoTa" value="<%=moTa%>"/>
                    <input type="hidden" name="hMonAnId" value="<%=monAnId%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    Mô tả:
                </td>
                <td>
                    <textarea name="txtNoiDung" rows="5"><%=noiDung%></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    Ảnh món ăn:
                </td>
                <td>
                    <input type="text" name="txtAnhMonAn" value="<%=anhMonAn%>"/>
                    <input type="file"/>
                </td>
            </tr>
            <tr>
                <td>
                    Chủ đề:
                </td>
                <td>
                    <input type="text" name="txtChuDe" value="<%=chuDe%>"/>
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input type="submit" name="btnCapNhat" value="Cập nhật"/>
                    &nbsp;
                    <a href="QuanLyMonAn.jsp">Trở lại</a>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
