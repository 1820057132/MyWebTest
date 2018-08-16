<%--
  Created by IntelliJ IDEA.
  User: xhbg
  Date: 2018/8/8
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script src="static/js/jquery-3.2.0.min.js"></script>
</head>
<body>

<button onclick="window.open('/user/register.jsp','注册')">注册</button>
&nbsp;
&nbsp;
&nbsp;
&nbsp;
<button onclick="window.open('/user/login.jsp','登陆')">登陆</button>
&nbsp;
&nbsp;
&nbsp;
&nbsp;
<button onclick="window.open('/user/updatePassWord.jsp','修改密码')">修改密码</button>
<br>
<br>
<br>

<form action="#" method="post">

    <img src="1" id="ava">
    <input type="file" id="file" onchange="upload()">

    <br>
    <br>
    <input type="submit">
</form>

<script type="text/javascript">
    function upload() {
        var formData = new FormData;
        formData.append("file",$("#file")[0].files[0]);
        $.ajax({
            url:"/headupload",
            contentType:false,//类型
            type:"POST",
            data:formData,
            processData: false,//序列化
            success:function (data) {
                console.log(data);
                $("#ava").attr("src",data);
            }
        });
    }
</script>
</body>
</html>
