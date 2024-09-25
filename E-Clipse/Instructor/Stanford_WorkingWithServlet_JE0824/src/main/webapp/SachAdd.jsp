<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vn.com.stanford.je0824.workingwithservlet.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới hoặc sửa thông tin sách</title>
</head>
<body>
	<%
	//Xử lý hiển thị chi tiết
	String sachId = "", tenSach = "", moTa = "", anhSach = "", tacGia = "";
	int giaSach = 0;
	if (request.getParameter("id") != null) {
		sachId = "" + request.getParameter("id");

		int id = 0;
		id = Integer.parseInt(sachId);

		//Lấy chi tiết
		Sach objSach = DataProvider.getSachBus().layChiTietTheoMa(id);

		if (objSach != null) {
			tenSach = objSach.getTenSach();
			moTa = objSach.getMoTa();
			anhSach = objSach.getAnhSach();
			tacGia = objSach.getTacGia();
			giaSach = objSach.getGiaSach();
		}
	}
	%>
	<div style="width: 100%; text-align: center;">
		<h2 style="text-transform: uppercase;">Thêm, sửa thông tin sách</h2>
	</div>

	<form action="SachServlet" method="post">
		<fieldset style="display: inline-block;">
			<legend>Nhập thông tin sách</legend>
			<table>
				<tr>
					<td>Tên sách:</td>
					<td><input type="text" name="txtTenSach" value="<%=tenSach%>" />
						<input type="hidden" name="hSachId" /></td>
				</tr>
				<tr>
					<td>Mô tả:</td>
					<td><textarea style="width: 170px" name="txtMoTa" rows="5"><%=moTa%></textarea>
					</td>
				</tr>
				<tr>
					<td>Ảnh sách:</td>
					<td><input type="text" name="txtAnhSach" value="<%=anhSach%>" />
						&nbsp; <input type="file" style="width: 190px" /></td>
				</tr>
				<tr>
					<td>Giá sách:</td>
					<td><input type="text" name="txtGiaSach" value="<%=giaSach%>" /></td>
				</tr>
				<tr>
					<td>Tác giả:</td>
					<td><input type="text" name="txtTacGia" value="<%=tacGia%>" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="btnCapNhat" value="Cập nhật" />
						&nbsp; &nbsp; <a href="QuanLySach.jsp">Trở lại</a></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>