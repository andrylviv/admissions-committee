<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 30.11.2021
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registered</title>
</head>
<body>
<h3>Applicant Account Info</h3>
<table>
    <c:set var="account" value="${sessionScope.account}" scope="page"/>
    <tr>
        <td>email:</td>
        <td><c:out value="${ account.email }" /></td>
    </tr>
    <tr>
        <td>firstName:</td>
        <td><c:out value="${ account.firstName }" /></td>
    </tr>
    <tr>
        <td>partonymic:</td>
        <td><c:out value="${ account.partonymic }" /></td>
    </tr>
    <tr>
        <td>city:</td>
        <td><c:out value="${ account.city }" /></td>
    </tr>
    <tr>
        <td>region:</td>
        <td><c:out value="${ account.region }" /></td>
    </tr>
    <tr>
        <td>school:</td>
        <td><c:out value="${ account.school }" /></td>
    </tr>
    <tr>
        <td>ukLang:</td>
        <td><c:out value="${ account.ukLang }" /></td>
    </tr>
    <tr>
        <td>ukLiter:</td>
        <td><c:out value="${ account.ukLiter }" /></td>
    </tr>
    <tr>
        <td>eng:</td>
        <td><c:out value="${ account.eng }" /></td>
    </tr>
    <tr>
        <td>algebra:</td>
        <td><c:out value="${ account.algebra }" /></td>
    </tr>
    <tr>
        <td>informatics:</td>
        <td><c:out value="${ account.informatics }" /></td>
    </tr>
    <tr>
        <td>geometry:</td>
        <td><c:out value="${ account.geometry }" /></td>
    </tr>
    <tr>
        <td>ukHistory:</td>
        <td><c:out value="${ account.ukHistory }" /></td>
    </tr>
    <tr>
        <td>phTraining:</td>
        <td><c:out value="${ account.phTraining }" /></td>
    </tr>
    <tr>
        <td>physics:</td>
        <td><c:out value="${ account.physics }" /></td>
    </tr>

</table>
</body>
</html>
