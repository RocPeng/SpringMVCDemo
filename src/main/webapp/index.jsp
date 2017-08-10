<%--
  Created by IntelliJ IDEA.
  User: roc_peng
  Date: 2017/8/9
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Welcome</title>
    <script src="${root}/WEB-INF/js/jquery-1.8.3.js"></script>
</head>
<script>
    function method1Click() {
        alert("点击!")
        $.ajax({
            url: "${root}/hello2/show3.do",
            type: "post",
            success: function (data) {
                console.log(data)
            }
        })
    }
</script>
<body>
<h1>Hello SpringMVC</h1>
<a href="${root}/hello.do">点我跳到hello</a>
<a href="${root}/hello2/show.do">点我跳到hello2</a><br/>
<a href="${root}/hello2/aaee/ant1.do">点我跳到Ant1 *</a><br/>
<a href="${root}/hello2/aaee/ff/gg/ant2.do">点我跳到Ant2 **</a><br/>
<a href="${root}/hello2/G/ant3.do">点我跳到Ant3 ?</a><br/>
<hr>
<a href="${root}/hello2/show1/10086.do">占位符格式1</a><br/>
<a href="${root}/hello2/001/鲤鱼/18.8/show2.do">占位符格式2</a><br/>
<hr>
<a id="method1" href="javascript:void(0)" onclick="method1Click()">只能使用Post</a><br/>
<a href="${root}/hello2/show4.do">使用Get或者Post</a><br/>
</body>
</html>
