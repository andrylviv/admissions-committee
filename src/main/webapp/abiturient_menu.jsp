<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 13.11.2021
  Time: 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>APPLICANT</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div align="right">
    <jsp:include page="langChange.jsp" />

</div>
<fmt:setLocale value = "${sessionScope.lang}"/>
<fmt:setBundle basename = "pagecontent" var = "lang"/>

<h2><fmt:message key = "label.helloAp" bundle = "${lang}"/> ${sessionScope.name}!</h2>
<a href="<c:url value="/list"/>"><fmt:message key = "label.facultyList" bundle = "${lang}"/></a>
<a href="<c:url value="/logout"/>"><fmt:message key = "label.logout" bundle = "${lang}"/></a>
</body>
</html>
