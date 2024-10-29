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
    <title>Thêm mới hoặc sửa thông tin chủ đề</title>
    <style type="text/css">
        .errorinfo
        {
            color: red;
        }
    </style>
</head>
<body>
<%--@elvariable id="sach" type="com"--%>
<c:url value="/admin/chude/themMoiCD" var="themMoiCD"/>
<c:url value="/admin/chude" var="troVeDanhSach"/>
<%--Khi object "chude" có thông tin, các trường đã khai báo trong lớp ChuDe cũng sẽ có thông tin --%>
<%--@elvariable id="chude" type="com"--%>
<form:form method="post" action="${themMoiCD}" modelAttribute="chude" acceptCharset="utf-8">
    <fieldset>
        <legend>Nhập thông tin chủ đề</legend>
        <div>
            <div>
                <label>Mã chủ đề:</label>
                <div>
                    <form:input path="maChuDe"/><br>
                    <form:errors path="maChuDe" cssClass="errorinfo"/>
                </div>
            </div>
            <div>
                <label>Tên chủ đề:</label>
                <div>
                    <form:input path="tenChuDe"/><br>
                    <form:errors path="tenChuDe" cssClass="errorinfo"/>
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
        </div>
    </fieldset>
</form:form>
</body>
</html>
