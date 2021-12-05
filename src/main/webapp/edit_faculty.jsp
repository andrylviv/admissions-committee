<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 20.11.2021
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Edit faculty</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        p {color:red;}
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
                <a class="nav-link" href="list"><fmt:message key = "label.back" bundle = "${lang}"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/logout"/>"><fmt:message key = "label.logout" bundle = "${lang}"/></a>
            </li>
            <li class="nav-item">

            </li>
        </ul>
    </div>
</nav>
<c:set var="command" value="${param.command}" scope="page"/>
<c:if test="${ not empty command and command eq 'edit' }">
    <h5>Edit faculty ${param.name}</h5>
<div align="right">
    <form action="<c:url value='/update_fty' ></c:url>">
        <input type="hidden" id="facultyId1" name="facultyId" value="${param.id}">
        <input type="hidden" id="command1" name="command" value="remove">
        <input type="submit" class="btn btn-danger" value="remove">
    </form>
</div>
    <form action="<c:url value='/update_fty' ></c:url>">
        <label for="fname">new faculty name:</label>
        <input type="text" id="nfname" name="fname" required value="${param.name}"><br><br>
        <label for="stfpl">new st. fon places:</label>
        <input type="number" id="nstfpl" name="stfpl" min="0" required value="${param.stFundedPlaces}"><br><br>
        <label for="totpl">new total places:</label>
        <input type="number" id="ntotpl" name="totpl" min="0" required value="${param.totPlaces}"><br><br>
        <input type="hidden" id="nlang" name="lang" value="${sessionScope.lang}">
        <input type="hidden" id="nfacultyId" name="facultyId" value="${param.id}">
        <input type="hidden" id="ncommand" name="command" value="edit">
        <c:set var="eieUkLang" value="${param.eieUkLang}" scope="page"/>
        <c:if test="${ not empty eieUkLang and eieUkLang eq 1 }">
            <input type="checkbox" id="nukLang" name="ukLang" value="1" checked>
            <label for="nukLang"> eie uk lang</label><br>
        </c:if>
        <c:set var="eieUkLang" value="${param.eieUkLang}" scope="page"/>
        <c:if test="${ not empty eieUkLang and eieUkLang eq 0 }">
            <input type="checkbox" id="nukLang" name="ukLang" value="1">
            <label for="nukLang"> eie uk lang</label><br>
        </c:if>
        <c:set var="eieMath" value="${param.eieMath}" scope="page"/>
        <c:if test="${ not empty eieMath and eieMath eq 1 }">
            <input type="checkbox" id="nmath" name="math" value="1" checked>
            <label for="nmath"> eie math</label><br>
        </c:if>
        <c:set var="eieMath" value="${param.eieMath}" scope="page"/>
        <c:if test="${ not empty eieMath and eieMath eq 0 }">
            <input type="checkbox" id="nmath" name="math" value="1">
            <label for="nmath"> eie math</label><br>
        </c:if>
        <c:set var="eiePhysics" value="${param.eiePhysics}" scope="page"/>
        <c:if test="${ not empty eiePhysics and eiePhysics eq 1 }">
            <input type="checkbox" id="nphysics" name="physics" value="1" checked>
            <label for="nphysics"> eie physics</label><br><br>
        </c:if>
        <c:set var="eiePhysics" value="${param.eiePhysics}" scope="page"/>
        <c:if test="${ not empty eiePhysics and eiePhysics eq 0 }">
            <input type="checkbox" id="nphysics" name="physics" value="1">
            <label for="nphysics"> eie physics</label><br><br>
        </c:if>
        <input type="submit" class="btn btn-success" value="Submit">
    </form>
    <c:set var="wrongCr" value="${param.wrongCr}" scope="page"/>
    <c:if test="${ not empty wrongCr and wrongCr eq 1 }">
        <p>wrong credentials</p>
    </c:if>
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
            <input type="checkbox" id="ukLang" name="ukLang" value="1">
            <label for="ukLang"> eie uk lang</label><br>
            <input type="checkbox" id="math" name="math" value="1">
            <label for="math"> eie math</label><br>
            <input type="checkbox" id="physics" name="physics" value="1">
            <label for="physics"> eie physics</label><br><br>
        <input type="submit" class="btn btn-success" value="Submit">
    </form>
    <c:set var="wrongCr" value="${param.wrongCr}" scope="page"/>
    <c:if test="${ not empty wrongCr and wrongCr eq 1 }">
        <p>wrong credentials</p>
    </c:if>
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
        <input type="submit" class="btn btn-success" value="Submit">
    </form>

</c:if>

</body>
</html>
