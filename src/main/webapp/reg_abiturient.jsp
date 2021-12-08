<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 15.11.2021
  Time: 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<fmt:setLocale value = "${sessionScope.lang}"/>
<fmt:setBundle basename = "pagecontent" var = "lang"/>
<div class="page-header" style="margin-bottom:0">
    <h2>admissions committee</h2>

</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

    <div class="collapse navbar-collapse" id="collapsibleNavbar">

    </div>
    <div align="right">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="login.jsp"><fmt:message key = "label.back" bundle = "${lang}"/></a>
            </li>
            <li class="nav-item">
                <jsp:include page="langChange.jsp" />
            </li>
        </ul>
    </div>
</nav>
<div class="container">
<h3>Register Account</h3>
${errors }
    <form action="reg_abiturient" method="POST">
        <table>
            <tr>
                <td><fmt:message key = "label.email" bundle = "${lang}"/></td>
                <td><input type="email" required name="email" value="${account.email }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.password" bundle = "${lang}"/></td>
                <td><input type="password" required name="password" value="${account.password }"/></td>
            </tr>

            <tr>
                <td><fmt:message key = "label.firstName" bundle = "${lang}"/></td>
                <td><input type="text" required name="first name" value="${account.firstName }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.lastName" bundle = "${lang}"/></td>
                <td><input type="text" required name="last name" value="${account.lastName }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.partonymic" bundle = "${lang}"/></td>
                <td><input type="text" required name="partonymic" value="${account.partonymic }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.city" bundle = "${lang}"/></td>
                <td><input type="text" required name="city" value="${account.city }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.region" bundle = "${lang}"/></td>
                <td><input type="text" required name="region" value="${account.region }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.school" bundle = "${lang}"/></td>
                <td><input type="text" required name="school" value="${account.school }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.ukLang" bundle = "${lang}"/></td>
                <td><input type="number" max="12" min="1" required name="uk lang" value="${account.ukLang }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.ukLiter" bundle = "${lang}"/></td>
                <td><input type="number" max="12" min="1" required name="uk liter" value="${account.ukLiter }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.eng" bundle = "${lang}"/></td>
                <td><input type="number" max="12" min="1" required name="eng" value="${account.eng }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.algebra" bundle = "${lang}"/></td>
                <td><input type="number" max="12" min="1" required name="algebra" value="${account.algebra }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.informatics" bundle = "${lang}"/></td>
                <td><input type="number" max="12" min="1" required name="informatics" value="${account.informatics }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.geometry" bundle = "${lang}"/></td>
                <td><input type="number" max="12" min="1" required name="geometry" value="${account.geometry }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.ukHistory" bundle = "${lang}"/></td>
                <td><input type="number" max="12" min="1" required name="uk history" value="${account.ukHistory }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.phTraining" bundle = "${lang}"/></td>
                <td><input type="number" max="12" min="1" required name="ph training" value="${account.phTraining }"/></td>
            </tr>
            <tr>
                <td><fmt:message key = "label.physics" bundle = "${lang}"/></td>
                <td><input type="number" max="12" min="1" required name="physics" value="${account.physics }"/></td>
            </tr>

          <tr>
              <td><input class="btn btn-info" type="submit" value="Реєстрація"></td>
          </tr>
      </table>
    </form>
</div>
</body>
</html>
