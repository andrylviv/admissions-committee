<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 13.11.2021
  Time: 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ABITURIENT</title>

</head>
<body>

<h2>Hello ABITURIENT ${sessionScope.name}!</h2>
<a href="<c:url value="/list"/>">Faculty List</a>
<a href="<c:url value="/logout"/>">Logout</a>
</body>
</html>
