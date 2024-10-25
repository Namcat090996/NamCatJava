<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/25/2024
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Thêm mới hoặc sửa thông tin sách</title>
</head>
<body>
<c:url value="/admin/sach/themMoiSach" var = "themMoiSach"/>
<c:url value="/admin/sach" var="troVeDanhSach"/>
<form:form method="post" action="themMoiSach" modelAttribute="sach" acceptCharset="utf-8">
    <fieldset>
        <legend>Nhập thông tin sách</legend>
        <div>
            <div>
                <label>Mã sách:</label>
                <div>
                    <form:input path="maSach"/><br>
                </div>
            </div>
            <div>
                <label>Tên sách:</label>
                <div>
                    <form:input path="tenSach"/><br>
                </div>
            </div>
            <div>
                <label>Mô tả:</label>
                <div>
                    <form:textarea path="moTa" rows="5"/><br>
                </div>
            </div>
            <div>
                <label>Ảnh sách:</label>
                <div>
                    <form:input path="anhSach"/><br>
                </div>
            </div>
            <div>
                <label>Giá sách:</label>
                <div>
                    <form:input path="giaSach"/><br>
                </div>
            </div>
            <div>
                <label>Tác giả:</label>
                <div>
                    <form:input path="tacGia"/><br>
                </div>
            </div>
            <div>
                <label>Mã CĐ:</label>
                <div>
                    <form:select path="maChuDe">
                        <form:option value="">-- Chọn chủ đề --</form:option>
                    <c:forEach var="cd" items="${chuDeList}">
                    </c:forEach>
                    </form:select>
                </div>
            </div>
            <div>
                <label></label>
                <div>
                    <input type="submit" value="Cập nhật"/>
                    &nbsp;
                    <a href="${troVeDanhSach}">Trở về</a>
                </div>
            </div>
        </div>
    </fieldset>
</form:form>
</body>
</html>
