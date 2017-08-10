<%--
  Created by IntelliJ IDEA.
  User: roc_peng
  Date: 2017/8/9
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <script src="mvc1/../../myjs/jquery-1.8.3.js"></script>
    <script src="${root}/myjs/jquery-1.8.3.js"></script>
</head>
<body>
    <h1>Hello222 JSP Page!!!</h1>
    <span style="color: red;font-size: 25px">${msg}</span><br>
    <span style="color: red;font-size: 25px">${username}</span>
</body>
</html>
