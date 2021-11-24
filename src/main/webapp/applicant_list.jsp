<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 24.11.2021
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Applicant</title>
    <style>
        form {margin: 1px;}
    </style>
</head>
<body>
<table>
    <tr>
        <%--    <th>Id</th>  --%>
        <th>Name</th>
        <th>Last name</th>
        <th>Partonymic</th>
    </tr>
    <c:forEach var="userInfoList" items="${sessionScope.userInfoList}" varStatus="status">
        <tr>
                <%--   <td><c:out value="${ usersInfo.id }" /></td>  --%>
            <td><c:out value="${ userInfoList.firstName }" /></td>
            <td><c:out value="${ userInfoList.lastName }" /></td>
            <td><c:out value="${ userInfoList.partonymic }" /></td>
                    <td>
                        <form action="statement" method="POST">
                            <input type="hidden" name="userId" value="${userInfoList.userId}" />
                            <input type="hidden" name="fId" value="${param.id}" />
                            <input type="hidden" name="command" value="delete" />
                            <a href="#" onclick="this.parentNode.submit()">delete</a>
                        </form>
                    </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
