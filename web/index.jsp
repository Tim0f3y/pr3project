<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28.05.2020
  Time: 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<div id="action_form" style="left: 50%;margin-left: -150px;position: absolute;width: 1000px;margin-top: 20%;">
    <form action="/" method="post">
        <input required type="text" name="login" placeholder="Логин">
        <input required type="text" name="password" placeholder="Пароль">
        <input type="submit" value="Войти">
    </form>
</div>
</body>
</html>
