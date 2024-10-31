<%--
  Created by IntelliJ IDEA.
  User: Dell Precision 7550
  Date: 10/31/2024
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Staff information management</title>
</head>
<body>
<c:url value="/admin/nhanien/them" var="urlSave"/>
<c:url value="/admin/nhanien/sua" var="urlUpdate"/>
<c:url value="/admin/nhanien/xoa" var="urlDelete"/>
<c:url value="/images" var="urlImage"/>
<c:url value="/admin/nhanien" var="urlSearch"/>
<div style="text-align: center">
    <h2>Staff information management</h2>
</div>
<form:form action="${urlSearch}"modelAttribute="nhanvien"acceptCharset="utf-8">

</form:form>
</body>
</html>
