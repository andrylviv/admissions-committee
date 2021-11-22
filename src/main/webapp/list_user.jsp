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
<table>
    <tr>
<%--    <th>Id</th>  --%>
        <th>Name</th>
        <th>Last name</th>
        <th>Partonymic</th>
    </tr>
    <c:forEach var="usersInfo" items="${usersInfo}" varStatus="status">
        <tr>
        <%--   <td><c:out value="${ usersInfo.id }" /></td>  --%>
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
   </body></html>
