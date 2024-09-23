<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới hoặc sửa thông tin sách</title>
</head>
<body>
<div style="width:100%; text-align:center;">
<h2 style="text-transform: uppercase;">Thêm, sửa thông tin sách</h2>
</div>

<form action="DangNhapServlet" method="get">
<fieldset>
	<legend>Nhập thông tin sách</legend>
	<table>
	<tr>
		<td>
		Tên sách:
		</td>
		<td>
			<input type="text" name="txtTenSach"/>
		</td>
	</tr>
	<tr>
		<td>
		Mô tả:
		</td>
		<td>
			<textarea name="txtMoTa" rows="5"></textarea>
		</td>
	</tr>
	<tr>
		<td>
		Ảnh sách:
		</td>
		<td>
			<input type="text" name="txtAnhSach"/>
			<input type="file"/>
		</td>
	</tr>
	<tr>
		<td>
		Giá sách:
		</td>
		<td>
			<input type="text" name="txtGiaSach"/>
		</td>
	</tr>
	<tr>
		<td>
		Tác giả:
		</td>
		<td>
			<input type="text" name="txtTacGia"/>
		</td>
	</tr>
	<tr>
		<td>
		
		</td>
		<td>
			<input type="submit" name="btnCapNhat" value="Cập nhật"/>
			&nbsp;
			<a href="QuanLySach.jsp">Trở lại</a>
		</td>
	</tr>
	</table>
</fieldset>
</form>
</body>
</html>