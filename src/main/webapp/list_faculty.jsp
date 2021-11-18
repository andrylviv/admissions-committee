<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 13.11.2021
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        h5 {color:red;}
    </style>
</head>
<body>
<div align="right">
    <form method="post" action="<c:url value='/list' ></c:url>">
        <label for="lang">Language:</label>
        <select name="lang" id="lang">
            <option value="uk">ukrainian</option>
            <option value="en">english</option>
        </select>
        <input type="hidden" id="uriVal" name="uriVal" value="list">
        <input type="hidden" id="command" name="command" value="langchange">
        <input type="submit" value="Submit">
    </form>
    <form method="post" action="<c:url value='/list' ></c:url>">
        <label for="sortType">Sort:</label>
        <select name="sortType" id="sortType">
            <option value="byName">by name</option>
            <option value="fp">founded places</option>
            <option value="tp">total places</option>
        </select>
        <input type="hidden" id="uriVal1" name="uriVal" value="list">
        <input type="hidden" id="command1" name="command" value="sort">
        <input type="submit" value="Submit">
    </form>
    <c:set var="block" value="${sessionScope.isBlocked}" scope="page"/>
    <c:if test="${ block eq '1' }">
        <h5>you blocked</h5>
    </c:if>
    <a href="<c:url value='/logout' />">Logout</a>
</div>
<hr>
<table>
    <c:forEach var="faculties" items="${sessionScope.faculties}" varStatus="status">
        <tr>

            <td><c:out value="${ faculties.name }" /></td>
            <td><c:out value="${ faculties.stFundedPlaces }" /></td>
            <td><c:out value="${ faculties.totPlaces }" /></td>
                <c:set var="user" value="${sessionScope.isAdmin}" scope="page"/>
                <c:set var="block" value="${sessionScope.isBlocked}" scope="page"/>
                <c:if test="${ not empty user and user eq '0' and block eq '0' }">
                    <td><a href="<c:url value='/reg_fty' >
                                <c:param name="id" value="${faculties.id}"/>
                                <c:param name="name" value="${faculties.name}"/>
                             </c:url>">register</a>
                    </td>

                </c:if>
            <c:set var="user" value="${sessionScope.isAdmin}" scope="page"/>
            <c:if test="${ not empty user and user eq '1' }">
                <td><a href="<c:url value='' >
                                <c:param name="id" value="${faculties.id}"/>
                                <c:param name="name" value="${faculties.name}"/>
                             </c:url>">edit faculty</a>
                </td>

            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
