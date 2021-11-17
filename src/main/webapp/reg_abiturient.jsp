<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 15.11.2021
  Time: 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="reg_abiturient" method="POST">
    <table>
        <tr>
            <td>email:</td>
            <td><input type="email" required name="email"/></td>
        </tr>
        <tr>
            <td>password:</td>
            <td><input type="password" required name="password"/></td>
        </tr>

        <tr>
            <td>first name:</td>
            <td><input type="text" required name="first name"/></td>
        </tr>
        <tr>
            <td>last name:</td>
            <td><input type="text" required name="last name"/></td>
        </tr>
        <tr>
            <td>partonymic:</td>
            <td><input type="text" required name="partonymic"/></td>
        </tr>
        <tr>
            <td>city:</td>
            <td><input type="text" required name="city"/></td>
        </tr>
        <tr>
            <td>region:</td>
            <td><input type="text" required name="region"/></td>
        </tr>
        <tr>
            <td>school:</td>
            <td><input type="text" required name="school"/></td>
        </tr>
        <tr>
            <td>uk lang:</td>
            <td><input type="number" max="12" min="1" required name="uk lang"/></td>
        </tr>
        <tr>
            <td>uk liter:</td>
            <td><input type="number" max="12" min="1" required name="uk liter"/></td>
        </tr>
        <tr>
            <td>eng:</td>
            <td><input type="number" max="12" min="1" required name="eng"/></td>
        </tr>
        <tr>
            <td>algebra:</td>
            <td><input type="number" max="12" min="1" required name="algebra"/></td>
        </tr>
        <tr>
            <td>informatics:</td>
            <td><input type="number" max="12" min="1" required name="informatics"/></td>
        </tr>
        <tr>
            <td>geometry:</td>
            <td><input type="number" max="12" min="1" required name="geometry"/></td>
        </tr>
        <tr>
            <td>uk history:</td>
            <td><input type="number" max="12" min="1" required name="uk history"/></td>
        </tr>
        <tr>
            <td>ph training:</td>
            <td><input type="number" max="12" min="1" required name="ph training"/></td>
        </tr>
        <tr>
            <td>physics:</td>
            <td><input type="number" max="12" min="1" required name="physics"/></td>
        </tr>
        <tr>
            <td>eie uk lang:</td>
            <td><input type="number" max="12" min="1" required name="eie uk lang"/></td>
        </tr>
        <tr>
            <td>eie math:</td>
            <td><input type="number" max="12" min="1" required name="eie math"/></td>
        </tr>
        <tr>
            <td><input class="button" type="submit" value="Реєстрація"></td>
        </tr>
    </table>
</form>
</body>
</html>
