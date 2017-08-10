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
    <script src="myjs/jquery-1.8.3.js"></script>
</head>
<script>
    function json3Click(url) {
        //通过Ajax post Json类型的数据到Controller
        $.ajax({
            url: url,
            type: "post",
            contentType: "application/json",//必须有
            dataType:'json', //表示返回值类型，不必须
//            data: "{'name': 'roc0','age': 22,'income': 6666.6,'interests': ['足球'],'marry': false}",
            data: JSON.stringify( {
                "name": "roc0",
                "age": 22,
                "income": 6666.6,
                "interests": [
                    "足球"
                ],
                "marry": false
            }),
            success: function (data) {
                alert("发送成功,发送数据原封不动返回:"+JSON.stringify(data))
            }
        })
    }
</script>
<body>
<h1>Hello SpringMVC</h1>
<h2>1.标准URL映射</h2>
<a href="${root}/hello.do">点我跳到hello</a>
<a href="${root}/hello2/show.do">点我跳到hello2</a><br/>
<hr>
<h2>2.Ant风格的映射（通配符)</h2>
<a href="${root}/hello2/aaee/ant1.do">点我跳到Ant1 *</a><br/>
<a href="${root}/hello2/aaee/ff/gg/ant2.do">点我跳到Ant2 **</a><br/>
<a href="${root}/hello2/G/ant3.do">点我跳到Ant3 ?</a><br/>
<hr>
<h2>3.占位符的映射</h2>
<a href="${root}/hello2/show1/10086.do">占位符格式1</a><br/>
<a href="${root}/hello2/001/鲤鱼/18.8/show2.do">占位符格式2</a><br/>
<hr>
<h2>4.限定请求方法的映射</h2>
<a href="${root}/hello2/show3.do">只能使用Post</a><br/>
<a href="${root}/hello2/show4.do">使用Get或者Post</a><br/>
<hr>
<h2>5.限定请求参数的映射</h2>
<a href="${root}/hello2/param1.do?id=123">必须含有id属性</a>
<a href="${root}/hello2/param2.do?id=123">必须不能含有id属性</a>
<a href="${root}/hello2/param3.do?id=123">id必须为1</a>
<a href="${root}/hello2/param4.do?id=123">id必须不为1</a>
<h1>接收数据及数据绑定</h1>
<h2>1.接收servlet的内置对象</h2>
<a href="${root}/hello2/built1.do">request response session</a><br>
<a href="${root}/hello2/built2.do">Model ModelMap</a><br>
<hr>
<h2>2.获取cookie</h2>
<a href="${root}/hello2/cookie1.do">cookie获取</a><br>
<a href="${root}/hello2/cookie2.do">cookie获取2</a><br>
<hr>
<h2>3.占位符参数获取</h2>
<a href="${root}/hello2/holder1/{666}.do">占位符参数</a><br>
<hr>
<h2>4.接收普通的请求参数</h2>
<a href="${root}/hello2/params1.do?id=22&username=roc_鹏">普通请求参数接收</a><br>
<a href="${root}/hello2/params2.do?id=22">普通请求参数接收 限定(是否可以为空)</a><br>
<a href="${root}/hello2/params3.do?id=22">普通请求参数接收 限定 默认值</a><br>
<hr>
<h2>5.基本数据类型的绑定</h2>
<form action="${root}/hello2/bind1.do" method="post">
    姓名:<input type="text" name="name"><br>
    年龄:<input type="text" name="age"><br>
    收入:<input type="text" name="income"><br>
    <%--on off 1/0 都可以在后台转成ture or false--%>
    已婚<input type="radio" name="isMarry" value="1">未婚<input type="radio" name="isMarry" value="0"><br>
    兴趣爱好<br>
    <input type="checkbox" name="interests" value="篮球">篮球<br>
    <input type="checkbox" name="interests" value="羽毛球">羽毛球<br>
    <input type="checkbox" name="interests" value="足球">足球<br>
    <input type="checkbox" name="interests" value="跳远">跳远<br>
    <input type="submit">
</form>
<hr>
<h2>6.pojo对象绑定</h2>
<form action="${root}/hello2/bind2.do" method="post">
    姓名:<input type="text" name="name"><br>
    年龄:<input type="text" name="age"><br>
    收入:<input type="text" name="income"><br>
    <%--on off 1/0 都可以在后台转成ture or false--%>
    已婚<input type="radio" name="isMarry" value="1">未婚<input type="radio" name="isMarry" value="0"><br>
    兴趣爱好<br>
    <input type="checkbox" name="interests" value="篮球">篮球<br>
    <input type="checkbox" name="interests" value="羽毛球">羽毛球<br>
    <input type="checkbox" name="interests" value="足球">足球<br>
    <input type="checkbox" name="interests" value="跳远">跳远<br>
    <input type="submit">
</form>
<hr>
<h2>7.集合的绑定</h2>
<a href="${root}/hello2/list1.do?users[0].name=alice&users[1].name=Bob&users[2].name=汤姆凯特">list集合的绑定</a><br>
<hr>
<h2>8.JSON数据的返回</h2>
<a href="${root}/hello2/json1.do">json数据返回</a>
<a href="${root}/hello2/json2.do">json数据返回</a><br>
<a href="javascript:void(0)" onclick="json3Click('${root}/hello2/json3.do')">post请求,发送json数据1</a><br>
<a href="javascript:void(0)" onclick="json3Click('${root}/hello2/json4.do')">post请求,发送json数据2</a><br>
<hr>
<h2>9.文件上传</h2>
<form action="${root}/hello2/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit">
</form>
<hr>
<h2>10.转发及重定向</h2>
<a href="${root}/hello2/redirect.do">重定向之后转发</a><br>
<a href="${root}/hello2/flash1.do">测试flash1</a><br>
</body>
</html>
