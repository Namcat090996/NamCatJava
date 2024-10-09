<%@ page import="vn.com.stanford.bst.model.ChuDeDao" %>
<%@ page import="vn.com.stanford.bst.model.ChuDeImpl" %>
<%@ page import="vn.com.stanford.bst.entities.ChuDe" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/8/2024
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm hoặc sửa chủ đề</title>
</head>
<%
    //Declare variables
    String chuDeId = "", maChuDe = "", tenChuDe = "";

    if(request.getParameter("id") != null)
    {
        //Get subject code
        chuDeId = request.getParameter("id");

        //Declare an object to get detailed subject using the function
        ChuDeDao chuDe = new ChuDeImpl();

        //Declare subject object
        ChuDe objChuDe = null;

        //Get a detailed subject from the subject code
        objChuDe = chuDe.layChiTiet(chuDeId);

        //Check if subject object is null
        if(objChuDe != null)
        {
            //Assign values to declared variables
            maChuDe = objChuDe.getMaChuDe();
            tenChuDe = objChuDe.getTenChuDe();
        }
    }
%>
<body>
<div style="text-align: center">
    <h2 style="text-transform: uppercase">Thêm, sửa thông tin sách</h2>
</div>
<form method="post" action="ChuDeServlet">
    <fieldset>
        <legend>Nhập thông tin chủ đề</legend>
        <table>
            <tr>
                <td>Mã chủ đề: </td>
                <td>
                    <input type="text" name="txtMaChuDe" value="<%=maChuDe%>">
                    <input type="hidden" name="hChuDeId" value="<%=chuDeId%>">
                </td>
            </tr>
            <tr>
                <td>Tên chủ đề: </td>
                <td>
                    <input type="text" name="txtTenChuDe" value="<%=tenChuDe%>">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" name="btnCapNhat" value="Cập nhật">
                    &nbsp;
                    <a href="QuanLyChuDe.jsp">Trở lại</a>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
