<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.05.2020
  Time: 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <td>Действия</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getLogin()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getRole()}</td>
                <td>
                    <form action="updateUser.jsp" method="post">
                        <input type="hidden" name="id" value="${user.getId()}">
                        <input type="hidden" name="name" value="${user.getName()}">
                        <input type="hidden" name="lastName" value="${user.getLastName()}">
                        <input type="hidden" name="login" value="${user.getLogin()}">
                        <input type="hidden" name="password" value="${user.getPassword()}">
                        <input type="hidden" name="role" value="${user.getRole()}">
                        <input type="submit" value="Изменить" style="float:left">
                    </form>
                    <form action="/admin/delete/" method="post">
                        <input type="hidden" name="id" value="${user.getId()}">
                        <input type="submit" value="Удалить" style="float:left">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <form action="/admin/addUser.jsp">
        <input type="submit" value="Добавить нового пользователя">
    </form>
</div>
</body>
</html>
