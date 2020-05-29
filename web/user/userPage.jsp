<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28.05.2020
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<div id="action_form" style="left: 50%;margin-left: -150px;position: absolute;width: 1000px;margin-top: 20%;">
    <table border="2">
        <tr>
            <td>ID</td>
            <td>Имя</td>
            <td>Фамилия</td>
            <td>Логин</td>
            <td>Пароль</td>
            <td>Роль</td>
        </tr>
        <c:forEach items="${user}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getLogin()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getRole()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
