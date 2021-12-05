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
        h5 {margin: 6px;}
    </style>
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
                <c:set var="block" value="${user.isBlocked}" scope="page"/>
                <c:if test="${ block eq '1' }">
                    <h5>blocked</h5>
                </c:if>
            </li>

            <li class="nav-item">

                <c:set var="block" value="${user.isBlocked}" scope="page"/>
                <c:if test="${ not empty block and block eq '0' and block eq '0' }">
                    <td><a class="nav-link" href="<c:url value='list_user' >
                                    <c:param name="id" value="${user.id}"/>
                                    <c:param name="bf" value="1"/>
                                    <c:param name="command" value="block"/>
                             </c:url>">block</a>
                    </td>
                </c:if>

                <c:set var="block" value="${user.isBlocked}" scope="page"/>
                <c:if test="${ not empty block and block eq '1' }">
                    <td><a class="nav-link" href="<c:url value='list_user' >
                                    <c:param name="id" value="${user.id}"/>
                                    <c:param name="bf" value="0"/>
                                    <c:param name="command" value="block"/>
                                 </c:url>">unblock</a>
                    </td>
                </c:if>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/logout"/>"><fmt:message key = "label.logout" bundle = "${lang}"/></a>
            </li>
        </ul>
    </div>
</nav>
<div  class="container">

    <table>

        <tr>
            <td>id:</td>
            <td><c:out value="${ user.id }" /></td>
        </tr>
        <tr>
            <td>email:</td>
            <td><c:out value="${ user.email }" /></td>
        </tr>
        <tr>
            <td>firstName:</td>
            <td><c:out value="${ uInfo.firstName }" /></td>
        </tr>
        <tr>
            <td>partonymic:</td>
            <td><c:out value="${ uInfo.partonymic }" /></td>
        </tr>
        <tr>
            <td>city:</td>
            <td><c:out value="${ uInfo.city }" /></td>
        </tr>
        <tr>
            <td>region:</td>
            <td><c:out value="${ uInfo.region }" /></td>
        </tr>
        <tr>
            <td>school:</td>
            <td><c:out value="${ uInfo.school }" /></td>
        </tr>
        <tr>
            <td>ukLang:</td>
            <td><c:out value="${ uInfo.ukLang }" /></td>
        </tr>
        <tr>
            <td>ukLiter:</td>
            <td><c:out value="${ uInfo.ukLiter }" /></td>
        </tr>
        <tr>
            <td>eng:</td>
            <td><c:out value="${ uInfo.eng }" /></td>
        </tr>
        <tr>
            <td>algebra:</td>
            <td><c:out value="${ uInfo.algebra }" /></td>
        </tr>
        <tr>
            <td>informatics:</td>
            <td><c:out value="${ uInfo.informatics }" /></td>
        </tr>
        <tr>
            <td>geometry:</td>
            <td><c:out value="${ uInfo.geometry }" /></td>
        </tr>
        <tr>
            <td>ukHistory:</td>
            <td><c:out value="${ uInfo.ukHistory }" /></td>
        </tr>
        <tr>
            <td>phTraining:</td>
            <td><c:out value="${ uInfo.phTraining }" /></td>
        </tr>
        <tr>
            <td>physics:</td>
            <td><c:out value="${ uInfo.physics }" /></td>
        </tr>
        <tr>
            <td>eieUkLang:</td>
            <td><c:out value="${ uInfo.eieUkLang }" /></td>
        </tr>
        <tr>
            <td>eieMath:</td>
            <td><c:out value="${ uInfo.eieMath }" /></td>
        </tr>
        <tr>
            <td>eiePhysics:</td>
            <td><c:out value="${ uInfo.eiePhysics }" /></td>
        </tr>

    </table>
</div>
</body>
</html>
