<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.05.2020
  Time: 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные пользователя</title>
</head>
<body>

Редактировать пользователя

<form action="/admin/update/" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="name" value="${param.name}" placeholder=${param.name}>
    <input type="text" name="lastName" value="${param.lastName}" placeholder=${param.lastName}>
    <input type="text" name="login" value="${param.login}" placeholder=${param.login}>
    <input type="text" name="password" value="${param.password}" placeholder=${param.password}>
    <input type="text" name="role" value="${param.role}" placeholder=${param.role}>
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>

</body>
</html>
