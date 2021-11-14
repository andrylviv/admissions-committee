<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 13.11.2021
  Time: 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

</head>
<body>

<div class="form">

    <h1>Вхід в систему</h1><br>
    <form method="post" action="">

        <input type="text" required placeholder="email" name="email"><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value="Увійти">
        <input class="button" type="submit" value="Реєстрація">
    </form>
</div>
</body>
</html>
