<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 20.11.2021
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>User Information</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        h5 {color:red;}
    </style>
</head>
<body>
<fmt:setLocale value = "${sessionScope.lang}"/>
<fmt:setBundle basename = "pagecontent" var = "lang"/>
<div align="right">
<c:set var="block" value="${user.isBlocked}" scope="page"/>
<c:if test="${ block eq '1' }">
    <h5>blocked</h5>
</c:if>

    <c:set var="block" value="${user.isBlocked}" scope="page"/>
    <c:if test="${ not empty block and block eq '0' and block eq '0' }">
        <td><a href="<c:url value='list_user' >
                                    <c:param name="id" value="${user.id}"/>
                                    <c:param name="bf" value="1"/>
                                    <c:param name="command" value="block"/>
                             </c:url>">block</a>
        </td>
    </c:if>

    <c:set var="block" value="${user.isBlocked}" scope="page"/>
    <c:if test="${ not empty block and block eq '1' }">
        <td><a href="<c:url value='list_user' >
                                    <c:param name="id" value="${user.id}"/>
                                    <c:param name="bf" value="0"/>
                                    <c:param name="command" value="block"/>
                                 </c:url>">unblock</a>
        </td>
    </c:if>
    <br>
    <a href="<c:url value="/logout"/>"><fmt:message key = "label.logout" bundle = "${lang}"/></a>
</div>
<hr>
<table>
    <tr>
        <td>id:<c:out value="${ user.id }" /></td>
    </tr>
    <tr>
        <td>email:<c:out value="${ user.email }" /></td>
    </tr>
    <tr>
        <td><c:out value="${ uInfo.firstName }" /></td>
    </tr>
    <tr>
        <td><c:out value="${ uInfo.partonymic }" /></td>
    </tr>
    <tr>
    <td><c:out value="${ uInfo.city }" /></td>
    </tr>
    <tr>
        <td><c:out value="${ uInfo.region }" /></td>
    </tr>
    <tr>
        <td><c:out value="${ uInfo.school }" /></td>
    </tr>
    <tr>
        <td><c:out value="${ uInfo.ukLang }" /></td>
    </tr>
    <tr>
        <td>ukLiter:<c:out value="${ uInfo.ukLiter }" /></td>
    </tr>
    <tr>
        <td>eng:<c:out value="${ uInfo.eng }" /></td>
    </tr>
    <tr>
        <td>algebra:<c:out value="${ uInfo.algebra }" /></td>
    </tr>
    <tr>
        <td>informatics:<c:out value="${ uInfo.informatics }" /></td>
    </tr>
    <tr>
        <td>geometry:<c:out value="${ uInfo.geometry }" /></td>
    </tr>
    <tr>
        <td>ukHistory:<c:out value="${ uInfo.ukHistory }" /></td>
    </tr>
    <tr>
        <td>phTraining:<c:out value="${ uInfo.phTraining }" /></td>
    </tr>
</table>
</body>
</html>
