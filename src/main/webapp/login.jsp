<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 13.11.2021
  Time: 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<fmt:setLocale value = "${sessionScope.lang}"/>
<fmt:setBundle basename = "pagecontent" var = "lang"/>

<div class="form">
    <h2><fmt:message key = "label.header" bundle = "${lang}"/><br/></h2><br>
    <form method="post" action="">
        <label for="email"><fmt:message key = "label.email" bundle = "${lang}"/></label><br>
        <input type="text" id="email" required placeholder="email" name="email"><br>
        <label for="password"><fmt:message key = "label.password" bundle = "${lang}"/></label><br>
        <input type="password" id="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value=<fmt:message key = "label.enter" bundle = "${lang}"/>>
      <!--  <input class="button" type="submit" value="Реєстрація">  -->
    </form>
    <form action="reg_abiturient.jsp">
        <input type="submit" value=<fmt:message key = "label.registration" bundle = "${lang}"/>>
    </form>
</div>
</body>
</html>
