<%@ page import="vn.com.namcat.servletworking.model.*"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới hoặc sửa thông tin sách</title>
</head>
<body>
<%
//Declare variables
String tenSach = "", anhSach = "", moTa = "", tacGia = "";
int giaSach = 0, sachId = 0;

if(request.getParameter("id") != null && !request.getParameter("id").isEmpty())
{
	//Get if of book
	sachId = Integer.parseInt(request.getParameter("id"));
	
	//Get object from id
	Sach objSach = DataSupplier.getSachBus().layChiTiet(sachId);
	
	//Assign value to textfield
	if(objSach != null)
	{
		tenSach = objSach.getTenSach();
		anhSach = objSach.getAnhSach();
		moTa = objSach.getMoTa();
		tacGia = objSach.getTacGia();
		giaSach = objSach.getGiaSach();		
	}
}
%>
<div style="text-align: center;">
	<h2 style="text-transform: uppercase;">Quản lý thông tin sách</h2>
</div>
<div style="width: 550px; margin: 0px auto">
<fieldset style="display: inline-block; border-radius: 3px">
<legend style="font-weight: bold;">Nhập thông tin sách</legend>
<form action="BookServlet" method="post">
<table>
	<tr>
		<td>Tên sách:</td>
		<td>
			<input type="text" name="txtTenSach" value="<%=tenSach %>"/>
			<input type="hidden" name="hSachId" value="<%=sachId %>">
		</td>
	</tr>
	<tr>
		<td>Mô tả:</td>
		<td><textarea name="txtMoTa" rows="5" style="width: 171px; font-family: Arial; font-size: 13.33px"><%=moTa%></textarea></td>
	</tr>
	<tr>
		<td>Ảnh sách:</td>
		<td>
			<input type="text" name="txtAnhSach" value="<%=anhSach %>"/> &nbsp;
			<input type="file">
		</td>
	</tr>
	<tr>
		<td>Giá sách:</td>
		<td><input type="text" name="txtGiaSach" value="<%=giaSach %>"/></td>
	</tr>
	<tr>
		<td>Tác giả:</td>
		<td><input type="text" name="txtTacGia" value="<%=tacGia %>"/></td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input type="submit" name="btnCapNhat" value="Cập nhật"/> &nbsp;
			<a href="BookManager.jsp">Trở lại</a>
		</td>
	</tr>
</table>
</form>
</fieldset>
</div>

</body>
</html>