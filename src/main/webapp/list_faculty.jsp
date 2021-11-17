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
</head>
<body>
<div align="right">
<form action="<c:url value='/lang_ch' ></c:url>">
    <label for="lang">Language:</label>
    <select name="lang" id="lang">
        <option value="uk">ukrainian</option>
        <option value="en">english</option>
    </select>
    <input type="hidden" id="uriVal" name="uriVal" value="list">
    <input type="submit" value="Submit">
</form>
</div>
<hr>
<table>
    <c:forEach var="faculties" items="${faculties}" varStatus="status">
        <tr>

            <td><c:out value="${ faculties.name }" /></td>
            <td><c:out value="${ faculties.stFundedPlaces }" /></td>
            <td><c:out value="${ faculties.totPlaces }" /></td>
            <td><a href="<c:url value='/reg_fty' >
                            <c:param name="id" value="${faculties.id}"/>
                            <c:param name="name" value="${faculties.name}"/>
                         </c:url>
            ">register</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
