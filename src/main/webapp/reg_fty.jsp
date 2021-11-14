<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 14.11.2021
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="ps" items="${param}">
        <c:out value="${ps.key} : ${ps.value}"/><br/>
    </c:forEach>
</body>
</html>
