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
    <script src="/static/js/jquery-3.2.0.min.js"></script>
</head>
<body>

电话：<input type="text" id="phone" disabled>
<br>
<br>
账号：<input type="text" id="name" disabled>
<br>
<br>
身份证：<input type="text" id="IDCard" disabled>
<br>
<br>
性别：<input type="text" name="sex" id="sex">
<br>
<br>
昵称：<input type="text" name="nickName" id="nickName">
<br>
<br>

<script type="text/javascript">

    function getInfo() {
        $.ajax({
            url: "/needLogin/myInfoJs",
            type: "post",
            dataType: "json",
            success: function (data) {
                console.log(data)
                $("#phone").val(data['phone']);
                $("#name").val(data['loginName']);
                $("#IDCard").val(data['iDCard']);
                $("#sex").val(data['sex']);
                $("#nickName").val(data['nickName']);
            },
            error: function (data) {
                console.log("失败")
            }
        })
    }

    getInfo()
</script>


</body>
</html>
