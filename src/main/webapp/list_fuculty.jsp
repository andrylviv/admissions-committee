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
<head><title>Core: forEach</title></head>
<body>
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
</body></html>
