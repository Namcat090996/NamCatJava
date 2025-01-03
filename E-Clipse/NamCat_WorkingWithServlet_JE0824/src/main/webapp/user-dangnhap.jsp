<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng nhập hệ thống</title>
<!-- Declare a css library -->
<link rel="stylesheet" type="text/css" href="bt1-style.css">
</head>

<body>
	<form action="dangnhap" method="get">
		<div style="width: 420px; margin: 30px auto;" class="box1">
			<fieldset class="login_group_field">
				<legend class="anno">Đăng nhập hệ thống</legend>
				<img class="login_group_field--image" src="images/login_icon.png">
				<table style="border-collapse: collapse;">
					<tr style="height: 30px;">
						<td class="td1">Tên đăng nhập:</td>
						<td><input class="DangNhap__text" type="text"
							name="txtTaiKhoan"></td>
					</tr>
					<tr style="height: 30px;">
						<td class="td1">Mật khẩu:</td>
						<td><input class="MatKhau__text" type="password"
							name="txtMatKhau"></td>
					</tr>
					<tr>
						<td></td>
						<td><input class="DangNhap__image" type="submit"
							value="Đăng nhập" name="btnDangNhap"> <input
							class="HuyBo__image" type="button" value="Hủy bỏ" name="btnHuyBo">
						</td>
					</tr>
					<tr>
						<td></td>
						<td><span style="color: red" id="error"></span></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</form>
</body>

</html>