<%@ page import="com.neusoft.servletTest.bean.user.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: xhbg
  Date: 2018/8/8
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/head.jsp" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form action="/login" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>

            <td>密码：</td>
            <td><input type="password" name="userPass"/></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input type="password" name="userPass" style="width: 114px"/>
                <img src="/codeservlet"
                     onclick="javascript:this.src='/codeservlet?'+ new Date().getTime()">
            </td>
        </tr>

    </table>
    <input type="submit" name="type">

</form>
<button onclick="window.open('/user/register.jsp','注册')">注册</button>
<br>


${sessionScope.code}
<%
    Boolean needLogin = Boolean.valueOf(request.getAttribute("needLogin") + "");
    if (needLogin) {
        out.print("<H1>请登陆</h1>");
    }

%>

<%
    Object codeInfo = request.getAttribute("codeInfo");
    if (codeInfo != null || !"".equals(codeInfo)) {
        out.print("<H1> " + codeInfo + "</h1>");
    }


%>
<br>
<%@ include file="/foot.jsp" %>
</body>
</html>
