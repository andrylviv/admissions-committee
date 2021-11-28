<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 14.11.2021
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <br>
<form action="reg_fty" method="POST">
   <c:set var="eie" value="${param.eieUkLang}" scope="page"/>
   <c:if test="${ not empty eie and eie eq '1' }">
       <tr>
           <td>eie uk lang:</td>
           <td><input type="number" max="12" min="1" required name="eieUkLang"/></td>
       </tr>
   </c:if>
   <c:set var="eie" value="${param.eieMath}" scope="page"/>
   <c:if test="${ not empty eie and eie eq '1' }">
       <tr>
           <td>eie math:</td>
           <td><input type="number" max="12" min="1" required name="eieMath"/></td>
       </tr>
   </c:if>
   <c:set var="eie" value="${param.eiePhysics}" scope="page"/>
   <c:if test="${ not empty eie and eie eq '1' }">
       <tr>
           <td>eie physics:</td>
           <td><input type="number" max="12" min="1" required name="eiePhysics"/></td>
       </tr>
   </c:if>
   <tr>
       <td>
           <input type="hidden" id="facultyId" name="facultyId" value="${param.id}">
           <input type="hidden" id="facultyName" name="facultyName" value="${param.facultyName}">
           <input type="hidden" id="command" name="command" value="${param.command}">
           <input class="button" type="submit" value="Реєстрація"></td>
   </tr>
</form>
</div>
</body>
</html>
