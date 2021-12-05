<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 24.11.2021
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Final list</title>
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
<div class="page-header" style="margin-bottom:0">
    <h2>admissions committee</h2>

</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">

        </ul>
    </div>
    <div align="right">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="list"><fmt:message key = "label.back" bundle = "${lang}"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/logout"/>"><fmt:message key = "label.logout" bundle = "${lang}"/></a>
            </li>

        </ul>
    </div>
</nav>
<div class="container">
    <table align="h">
        <h4> State founded places</h4>
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
        <h4>Non state founded places</h4>
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
</div>
</body>
</html>
