<%--
  Created by IntelliJ IDEA.
  User: HY
  Date: 2020/2/4
  Time: 23:04
  功能: 登录页面
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
         language="java" import="java.util.*"%>
<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="login" method="post">
        账号: <input type="text" name="name"> <br>
        密码: <input type="password" name="password"> <br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
