<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.05.2020
  Time: 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить нового пользователя</title>
</head>
<body>
<form action = "/add/" method="post">
    <input required type="text" name="name" placeholder="Имя">
    <input required type="text" name="lastName" placeholder="Фамилия">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
