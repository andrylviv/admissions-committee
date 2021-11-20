<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 20.11.2021
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit faculty</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="command" value="${param.command}" scope="page"/>
<c:if test="${ not empty command and command eq 'edit' }">
    <h2>Edit faculty ${param.name}</h2>

    <form action="<c:url value='/update_fty' ></c:url>">
        <label for="fname">new faculty name:</label>
        <input type="text" id="nfname" name="fname" required><br><br>
        <label for="stfpl">new st. fon places:</label>
        <input type="number" id="nstfpl" name="stfpl" min="0" required><br><br>
        <label for="totpl">total places:</label>
        <input type="number" id="ntotpl" name="totpl" min="0" required><br><br>
        <input type="hidden" id="nlang" name="lang" value="${sessionScope.lang}">
        <input type="hidden" id="nfacultyId" name="facultyId" value="${param.id}">
        <input type="hidden" id="ncommand" name="command" value="edit">
        <input type="submit" value="Submit">
    </form>

</c:if>
<c:set var="command" value="${param.command}" scope="page"/>
<c:if test="${ not empty command and command eq 'add' }">
    <h2>Add faculty</h2>

    <form action="<c:url value='/update_fty' ></c:url>">
        <label for="fname">faculty name:</label>
        <input type="text" id="fname" name="fname" required><br><br>
        <label for="stfpl">st. fon places:</label>
        <input type="number" id="stfpl" name="stfpl" min="0" required><br><br>
        <label for="totpl">total places:</label>
        <input type="number" id="totpl" name="totpl" min="0" required><br><br>
        <input type="hidden" id="lang" name="lang" value="${sessionScope.lang}">
        <input type="hidden" id="facultyId" name="facultyId" value="${param.id}">
        <input type="hidden" id="command" name="command" value="add">
        <input type="submit" value="Submit">
    </form>

</c:if>

<c:set var="command" value="${param.command}" scope="page"/>
<c:if test="${ not empty command and command eq 'addLocale' }">
    <h2>Add faculty locale</h2>

    <form action="<c:url value='/update_fty' ></c:url>">
        <label for="fname">faculty name:</label>
        <input type="text" id="lfname" name="fname" required><br><br>

        <input type="hidden" id="llang" name="lang" value="${sessionScope.lang}">
        <input type="hidden" id="lfacultyId" name="facultyId" value="${param.id}">
        <input type="hidden" id="lcommand" name="command" value="addLocale">
        <input type="submit" value="Submit">
    </form>

</c:if>

</body>
</html>