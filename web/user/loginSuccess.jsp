<%--
  Created by IntelliJ IDEA.
  User: xhbg
  Date: 2018/8/11
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<br>


<h1>登陆成功</h1>
${sessionScope.loginName}
<hr>
${loginName}

<a href="/needLogin/myInfo"><button>个人信息</button></a>

<a href="myInfoWithJs.jsp"><button>个人信息js</button></a>

</body>
</html>
