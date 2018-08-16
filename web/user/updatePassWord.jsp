<%--
  Created by IntelliJ IDEA.
  User: xhbg
  Date: 2018/8/14
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>

<form method="post" action="/updatePass">
    用户名：<input type="text" name="userName">
<br>
<br>
    老密码：<input type="password" name="oldPass">
<br>
<br>
    新密码：<input type="password" name="newPass">
<br>
<br>
    确认新密码：<input type="password" name="sureNewPass">
<br>
<br>
    验证码：<input type="text" name="code">
    <img src="/codeservlet" onclick="javascript:this.src='/codeservlet?'+new Date().getTime()">
<br>
<br>

    <input type="submit"><!--提交按钮-->
</form>



</body>
</html>
