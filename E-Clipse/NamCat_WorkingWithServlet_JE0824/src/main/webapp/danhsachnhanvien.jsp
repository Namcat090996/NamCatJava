<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách người dùng</title>
    <!-- Get font from google font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">    
    <!-- Declare a css library -->
    <link rel="stylesheet" href="reset.css">
	<link rel="stylesheet" href="style2.css">
</head>
<body>
    <form action="danhsach" method="post">
        <table style="margin-left: auto; margin-right: auto;">
            <tr class="tr-main">
                <th></th>
                <th>Tài khoản</th>
                <th>Họ tên</th>
                <th>Điện thoại</th>
                <th>Email</th>
                <th>Địa chỉ</th>
                <th></th>
            </tr>
            <tr class="tr-odd">
                <td>
                    <img src="images/user1.png" alt="" />
                </td>
                <td>anhtl</td>
                <td>Trương Lan Anh</td>
                <td></td>
                <td>truonglananh@yahoo.com</td>
                <td>Hà Nội</td>
                <td style="text-align: center;">
                    <a class="info" href="#"><img src="images/act_edit.gif" style="width: 15px;" /></a>
                        &nbsp;
                    <a href="#"><img src="images/delete.gif" style="width: 20px;" /></a>
                </td>
            </tr>
            <tr class="tr-even">
                <td>
                    <img src="images/user2.png" alt="" />
                </td>
                <td>phuongtt</td>
                <td>Trần Thanh Phương</td>
                <td></td>
                <td>phuongtran311@gmail.com</td>
                <td>Hà Nội</td>
                <td style="text-align: center;">
                    <a class="info" href="#"><img src="images/act_edit.gif" style="width: 15px;" /></a>
                        &nbsp;
                    <a href="#"><img src="images/delete.gif" style="width: 20px;" /></a>
                </td>
            </tr>
            <tr class="tr-odd">
                <td>
                    <img src="images/user1.png" alt="" />
                </td>
                <td>tamht</td>
                <td>Hoàng Thị Tâm</td>
                <td></td>
                <td>nangmuadong18@gmail.com</td>
                <td>Hải Dương</td>
                <td style="text-align: center;">
                    <a class="info" href="#"><img src="images/act_edit.gif" style="width: 15px;" /></a>
                        &nbsp;
                    <a href="#"><img src="images/delete.gif" style="width: 20px;" /></a>
                </td>
            </tr>
            <tr class="tr-even">
                <td>
                    <img src="images/user2.png" alt="" />
                </td>
                <td>chungvv</td>
                <td>Vũ Văn Chung</td>
                <td></td>
                <td>chungh3t@yahoo.com</td>
                <td>Hà Nội</td>
                <td style="text-align: center;">
                    <a class="info" href="#"><img src="images/act_edit.gif" style="width: 15px;" /></a>
                        &nbsp;
                    <a href="#"><img src="images/delete.gif" style="width: 20px;" /></a>
                </td>
            </tr>
            <tr class="tr-odd">
                <td>
                    <img src="images/user1.png" alt="" />
                </td>
                <td>hungld</td>
                <td>Lê Đình Hưng</td>
                <td></td>
                <td>Ledinhhung.230990@gmail.com</td>
                <td>Thanh Hóa</td>
                <td style="text-align: center;">
                    <a class="info" href="#"><img src="images/act_edit.gif" style="width: 15px;" /></a>
                        &nbsp;
                    <a href="#"><img src="images/delete.gif" style="width: 20px;" /></a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>