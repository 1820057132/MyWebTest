<%--
  Created by IntelliJ IDEA.
  User: xhbg
  Date: 2018/8/9
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/register" method="post">
    用户名：<input type="text" name="loginName"/>
    <br/><br/>
    密码：<input type="password" name="loginPwd"/>
    <br/><br/>
    性别：<input type="radio" name="sex" value="男">男
    <input type="radio" name="sex" value="女">女

    <br/><br/>
    <input type="submit">
</form>
</body>
</html>
