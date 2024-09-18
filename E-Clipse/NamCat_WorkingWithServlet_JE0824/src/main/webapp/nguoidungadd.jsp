<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Đăng ký người dùng</title>
<!-- Declare a css library -->
<link rel="stylesheet" type="text/css" href="bt1-style.css">
</head>

<body>
	<!-- Tạo menu -->
	<form action="nguoidung" method="post">
		<fieldset style="display: inline-block;">
			<legend>Nhập thông tin đăng ký</legend>
			<table>
				<tr>
					<td>Tài khoản:</td>
					<td><input type="text" id="txtTaiKhoan" /></td>
				</tr>
				<tr>
					<td>Mật khẩu:</td>
					<td><input type="password" id="txtMatKhau" /></td>
				</tr>
				<tr>
					<td>Mật khẩu nhập lại:</td>
					<td><input type="password" id="txtMatKhauNhapLai" /></td>
				</tr>
				<tr>
					<td>Họ tên:</td>
					<td><input type="text" id="txtHoTen" /></td>
				</tr>
				<tr>
					<td>Giới tính:</td>
					<td><input type="radio" name="gt" />Nam &nbsp; <input
						type="radio" name="gt" />Nữ</td>
				</tr>
				<tr>
					<td>Ngày sinh:</td>
					<td><input type="date" id="txtNgaySinh" /></td>
				</tr>
				<tr>
					<td>Điện thoại:</td>
					<td><input type="text" id="txtDienThoai" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" id="txtEmail" /></td>
				</tr>
				<tr>
					<td>Địa chỉ:</td>
					<td><textarea rows="5"></textarea></td>
				</tr>
				<tr>
					<td>Trình độ</td>
					<td><select>
							<option value="THPT">THPT</option>
							<option value="TCCN">Trung cấp</option>
							<option value="CD">Cao đẳng</option>
							<option value="DH">Đại học</option>
							<option value="ThS">Thạc Sỹ</option>
							<option value="TS">Tiến Sỹ</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Đăng ký" id="btnDangKy" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>

</html>