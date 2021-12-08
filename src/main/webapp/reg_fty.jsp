<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 14.11.2021
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
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
            <li class="nav-item">

            </li>
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
    <br>
<form action="reg_fty" method="POST">
   <c:set var="eie" value="${param.eieUkLang}" scope="page"/>
   <c:if test="${ not empty eie and eie eq '1' }">
       <tr>
           <td><fmt:message key = "label.eieUkLang" bundle = "${lang}"/></td>
           <td><input type="number" max="12" min="1" required name="eieUkLang"/></td>
       </tr>
   </c:if>
   <c:set var="eie" value="${param.eieMath}" scope="page"/>
   <c:if test="${ not empty eie and eie eq '1' }">
       <tr>
           <td><fmt:message key = "label.eieMath" bundle = "${lang}"/></td>
           <td><input type="number" max="12" min="1" required name="eieMath"/></td>
       </tr>
   </c:if>
   <c:set var="eie" value="${param.eiePhysics}" scope="page"/>
   <c:if test="${ not empty eie and eie eq '1' }">
       <tr>
           <td><fmt:message key = "label.eiePhysics" bundle = "${lang}"/></td>
           <td><input type="number" max="12" min="1" required name="eiePhysics"/></td>
       </tr>
   </c:if>
       <tr>
           <td>
               <input type="hidden" id="facultyId" name="facultyId" value="${param.id}">
               <input type="hidden" id="facultyName" name="facultyName" value="${param.facultyName}">
               <input type="hidden" id="command" name="command" value="${param.command}">
               <input class="btn btn-info" type="submit" value="Реєстрація">
           </td>
       </tr>
</form>
</div>
</body>
</html>
