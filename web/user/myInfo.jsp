<%--
  Created by IntelliJ IDEA.
  User: xhbg
  Date: 2018/8/15
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<form action="#" method="post">
    电话：<input type="text" value="${requestScope.phone}" disabled>
    <br>
    <br>
    账号：<input type="text" value="${requestScope.name}" disabled>
    <br>
    <br>
    身份证：<input type="text" value="${requestScope.IDCard}" disabled>
    <br>
    <br>
    性别：<input type="text" name="sex" value="${requestScope.sex}">
    <br>
    <br>
    昵称：<input type="text" name="nickName" value="${requestScope.nickName}">
    <br>
    <br>
    <input type="submit">
</form>


</body>
</html>
