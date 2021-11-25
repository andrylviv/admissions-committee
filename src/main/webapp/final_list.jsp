<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 24.11.2021
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Final list</title>
</head>
<body>
<table align="h">
    <h3> State founded places</h3>
    <tr>
        <th>Name</th>
        <th>Last name</th>
        <th>Partonymic</th>
    </tr>
    <c:forEach var="finStF" items="${requestScope.finStF}" varStatus="status">
        <tr>
            <td><c:out value="${ finStF.firstName }" /></td>
            <td><c:out value="${ finStF.lastName }" /></td>
            <td><c:out value="${ finStF.partonymic }" /></td>

        </tr>
    </c:forEach>
</table>
<table>
    <h3>Non state founded places</h3>
    <tr>
        <th>Name</th>
        <th>Last name</th>
        <th>Partonymic</th>
    </tr>
    <c:forEach var="finNonStF" items="${requestScope.finNonStF}" varStatus="status">
        <tr>
            <td><c:out value="${ finNonStF.firstName }" /></td>
            <td><c:out value="${ finNonStF.lastName }" /></td>
            <td><c:out value="${ finNonStF.partonymic }" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
