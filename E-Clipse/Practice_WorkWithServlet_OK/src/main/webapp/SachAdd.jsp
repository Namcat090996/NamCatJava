<%@page import="java.util.ArrayList, java.util.List, vn.com.namcat.servletwork.model.*"%>
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
	String sachId = "", tenSach = "", anhSach = "", moTa = "", tacGia = "";
	int id = 0, giaSach = 0;
	
	//Get Sach object by function
	if(request.getParameter("id") != null && !request.getParameter("id").isEmpty())
	{
		//Get id from the book
		sachId = request.getParameter("id");
		
		//Conver id to int
		id = Integer.parseInt(sachId);
		
		//Get book object through function
		Sach objSach = DataProvider.getSachBus().layChiTietTheoMa(id);
		
		//Assign value from book object to variables
		if(objSach != null)
		{
			tenSach = objSach.getTenSach();
			moTa = objSach.getMoTa();
			anhSach = objSach.getAnhSach();
			giaSach = objSach.getGiaSach();
			tacGia = objSach.getTacGia();			
		}
	}
	%>
	<div style="width: 100%; text-align: center;">
		<h2 style="text-transform: uppercase;">Thêm, sửa thông tin sách</h2>
	</div>
	<div style="width: 500px; margin: 30px auto">
		<form action="sachadd" method="post">
			<fieldset style="display: inline-block; border-radius: 5px">
				<legend>Nhập thông tin sách</legend>
				<table>
					<tr>
						<td>Tên sách:</td>
						<td>
							<input type="text" name="txtTenSach" value="<%=tenSach %>" /> 
							<input type="text" name="hSachId" value="<%=id %>" />
						</td>
					</tr>
					<tr>
						<td>Mô tả:</td>
						<td>
							<textarea style="width: 170px; font-family: Arial; font-size: 13.3333px" name="txtMoTa" rows=5><%=moTa %></textarea>
						</td>
					</tr>
					<tr>
						<td>Ảnh sách:</td>
						<td>
							<input type="text" name="txtAnhSach" value="<%=anhSach %>" /> &nbsp; 
							<input type="file" style="width: 190px">
						</td>
					</tr>
					<tr>
						<td>Giá sách:</td>
						<td>
							<input type="text" name="txtGiaSach" value="<%=giaSach %>" />
						</td>
					</tr>
					<tr>
						<td>Tác giả:</td>
						<td>
							<input type="text" name="txtTacGia" value="<%=tacGia %>" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" value="Cập nhật" name="btnCapNhat" />
							&nbsp; &nbsp; 
							<a href="QuanLySach.jsp">Trở lại</a>
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>