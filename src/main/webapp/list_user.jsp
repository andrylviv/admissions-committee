<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 13.11.2021
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Core: forEach</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        form {margin: 1px;}
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
                <a class="nav-link" href="admin_menu.jsp"><fmt:message key = "label.back" bundle = "${lang}"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/logout"/>"><fmt:message key = "label.logout" bundle = "${lang}"/></a>
            </li>
            <li class="nav-item">

            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Last name</th>
            <th>Partonymic</th>
        </tr>
        <c:forEach var="usersInfo" items="${usersInfo}" varStatus="status">
            <tr>
                   <td><c:out value="${ usersInfo.userId }" /></td>
                   <td><c:out value="${ usersInfo.firstName }" /></td>
                   <td><c:out value="${ usersInfo.lastName }" /></td>
                   <td><c:out value="${ usersInfo.partonymic }" /></td>
                   <td><a href="<c:url value='list_user' >
                                   <c:param name="userId" value="${usersInfo.userId}"/>
                                   <c:param name="command" value="userInfo"/>
                                </c:url>
                   ">applicant information</a>
                   </td>
               </tr>
           </c:forEach>
   </table>

</div>
<ul class="pagination pagination-sm justify-content-end">

    <c:set var="page" value="${sessionScope.page}" scope="page"/>
    <c:if test="${ not empty page and page != 1 }">
    <li class="page-item"><a class="page-link" href="list_user?command=lou&page=${requestScope.pageP}">Previous</a></li>
    <li class="page-item"><a class="page-link" href="list_user?command=lou&page=${requestScope.pageP}">${requestScope.pageP}</a></li>
    </c:if>
    <li class="page-item active"><a class="page-link" href="list_user?command=lou&page=${requestScope.page}">${requestScope.page}</a></li>
    <li class="page-item"><a class="page-link" href="list_user?command=lou&page=${requestScope.pageN}">${requestScope.pageN}</a></li>
    <li class="page-item"><a class="page-link" href="list_user?command=lou&page=${requestScope.pageN}">Next</a></li>
</ul>
</body>
</html>
