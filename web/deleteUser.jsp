<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.05.2020
  Time: 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить пользователя</title>
</head>
<body>

Вы действительно хотите удалить пользователя ${param.id}?

<form action="/delete/${param.id}" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="hidden" name="_method" value="Удалить">
    <input type="submit" value="Удалить">
</form>

</body>
</html>
