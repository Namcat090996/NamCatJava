<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/28/2024
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Declare tag library of Spring MVC --%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Thêm mới hoặc sửa thông tin sách</title>
    <style type="text/css">
        .errorinfo
        {
            color: red;
        }
    </style>
</head>
<body>
<%--@elvariable id="sach" type="com"--%>
<c:url value="/admin/sach/themMoiSach" var="themMoiSach"/>
<c:url value="/admin/sach" var="troVeDanhSach"/>
<form:form method="post" action="${themMoiSach}" modelAttribute="sach" acceptCharset="utf-8">
    <fieldset>
        <legend>Nhập thông tin sách</legend>
        <div>
            <div>
                <label>Mã sách:</label>
                <div>
                    <form:input path="maSach"/><br>
                    <form:errors path="maSach" cssClass="errorinfo"/>
                    <input type="hidden" name="hSachId" value="${idCheck}">
                </div>
                <div style="color: red">${sach_message}</div>
            </div>
            <div>
                <label>Tên sách:</label>
                <div>
                    <form:input path="tenSach"/><br>
                    <form:errors path="tenSach" cssClass="errorinfo"/>
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
                    <form:errors path="giaSach" cssClass="errorinfo"/>
                </div>
            </div>
            <div>
                <label>Tác giả:</label>
                <div>
                    <form:input path="tacGia"/><br>
                </div>
            </div>
            <div>
                <label>Mã chủ đề:</label>
                <div>
                    <form:select path="maChuDe">
                        <form:option value="">--Chọn chủ đề--</form:option>
                        <c:forEach var="cd" items="${chuDeList}">
                            <form:option value="${cd.maChuDe}">${cd.tenChuDe}</form:option>
                        </c:forEach>
                    </form:select><br>
                    <form:errors path="maChuDe" cssClass="errorinfo"/>
                </div>
            </div>
            <div>
                <label></label>
                <div>
                    <input type="submit" value="Cập nhật"/>
                    &nbsp;
                    <a href="${troVeDanhSach}">Trở lại</a>
                </div>
            </div>
            <div>
                <label></label>
                <div>${message}</div>
            </div>
        </div>
    </fieldset>
</form:form>
</body>
</html>
