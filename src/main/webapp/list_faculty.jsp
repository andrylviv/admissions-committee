<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 13.11.2021
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>List faculty</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        h5 {color:red;}
        form {margin:0px;}
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
            <c:set var="user" value="${sessionScope.isAdmin}" scope="page"/>
            <c:if test="${ not empty user and user eq '1' }">
                <a class="nav-link" href="<c:url value='edit_faculty.jsp' >
                                        <c:param name="command" value="add"/>
                                     </c:url>"><fmt:message key = "label.add" bundle = "${lang}"/>
                </a>
                <form action="statement" method="POST">
                    <input type="hidden" name="command" value="fin" />
                    <a class="nav-link" href="#" onclick="this.parentNode.submit()"><fmt:message key = "label.finalise" bundle = "${lang}"/></a>
                </form>
            </c:if>

        </ul>
    </div>
    <div align="right">
        <ul class="navbar-nav">

            <li class="nav-item">

                <form method="post" action="<c:url value='/list' ></c:url>">
                    <%--    <label for="lang">Language:</label>   --%>
                    <select name="lang" id="lang">
                        <option value="uk"><fmt:message key = "label.uk" bundle = "${lang}"/></option>
                        <option value="en"><fmt:message key = "label.en" bundle = "${lang}"/></option>
                    </select>
                    <input type="hidden" id="uriVal" name="uriVal" value="list">
                    <input type="hidden" id="command" name="command" value="langchange">
                    <input type="submit" value="Submit">
                </form>
            </li>
            <li class="nav-item">
                <form method="post" action="<c:url value='/list' ></c:url>">
                    <%--    <label for="sortType">Sort:</label>  --%>
                    <select name="sortType" id="sortType">
                        <option value="byName"><fmt:message key = "label.byName" bundle = "${lang}"/></option>
                        <option value="fp"><fmt:message key = "label.stFouPlaces" bundle = "${lang}"/></option>
                        <option value="tp"><fmt:message key = "label.totalPlaces" bundle = "${lang}"/></option>
                    </select>
                    <input type="hidden" id="uriVal1" name="uriVal" value="list">
                    <input type="hidden" id="command1" name="command" value="sort">
                    <input type="submit" value="Submit">
                </form>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="<c:url value="/logout"/>"><fmt:message key = "label.logout" bundle = "${lang}"/></a>
            </li>
        </ul>
    </div>
</nav>

<div align="right">


    <c:set var="block" value="${sessionScope.isBlocked}" scope="page"/>
    <c:if test="${ block eq '1' }">
        <h5>blocked</h5>
    </c:if>
    <%--    <a href="<c:url value='/logout' />"><fmt:message key = "label.logout" bundle = "${lang}"/></a> --%>
</div>

        <div class="container-fluid">
        <table>
            <tr>
                <th><fmt:message key = "label.faculty" bundle = "${lang}"/></th>
                <th><fmt:message key = "label.stFouPlaces" bundle = "${lang}"/></th>
                <th><fmt:message key = "label.totalPlaces" bundle = "${lang}"/></th>
            </tr>
            <c:forEach var="faculties" items="${sessionScope.faculties}" varStatus="status">
                <tr>

                    <td><c:out value="${ faculties.name }" /></td>
                    <td><c:out value="${ faculties.stFundedPlaces }" /></td>
                    <td><c:out value="${ faculties.totPlaces }" /></td>
                        <c:set var="user" value="${sessionScope.isAdmin}" scope="page"/>
                        <c:set var="block" value="${sessionScope.isBlocked}" scope="page"/>
                        <c:if test="${ not empty user and user eq '0' and block eq '0' }">           <%--if user abiturient--%>
                    <c:set var="fl" value="0" scope="page"/>
                    <c:forEach var="usfaculty" items="${sessionScope.usfaculty}" varStatus="status">
                        <c:set var="fidList" value="${faculties.id}" scope="page"/>
                        <c:set var="fidFI" value="${usfaculty.facultyId}" scope="page"/>
                        <c:set var="usId" value="${usfaculty.userId}" scope="page"/>
                        <c:set var="abId" value="${sessionScope.id}" scope="page"/>
                        <c:if test="${ not empty fidList and fidList eq fidFI and usId eq abId}">
                            <c:set var="fl" value="1" scope="page"/>

                                 <td>
                                     <form action="reg_fty" method="POST">
                                         <input type="hidden" name="id" value="${faculties.id}" />
                                         <input type="hidden" name="facultyName" value="${faculties.name}" />
                                         <input type="hidden" name="command" value="unregister" />
                                         <a href="#" onclick="this.parentNode.submit()" class="btn btn-warning" role="button"><fmt:message key = "label.unregister" bundle = "${lang}"/></a>
                                     </form>
                                 </td>
                        </c:if>
                    </c:forEach>

                             <c:if test="${ fl != 1}">
                                 <td><a href="<c:url value='/reg_fty.jsp' >
                                                 <c:param name="id" value="${faculties.id}"/>
                                                 <c:param name="facultyName" value="${faculties.name}"/>
                                                 <c:param name="eieUkLang" value="${faculties.isEieUkLang}"/>
                                                 <c:param name="eieMath" value="${faculties.isEieMath}"/>
                                                 <c:param name="eiePhysics" value="${faculties.isEiePhysics}"/>
                                                 <c:param name="command" value="register"/>
                                              </c:url>" class="btn btn-info" role="button"><fmt:message key = "label.register" bundle = "${lang}"/></a>
                                 </td>
                                 <c:set var="fl" value="0" scope="page"/>
                             </c:if>

                </c:if>


                 <c:set var="user" value="${sessionScope.isAdmin}" scope="page"/>
                 <c:if test="${ not empty user and user eq '1' }">                        <%--if user administrator--%>
                     <td><a href="<c:url value='edit_faculty.jsp' >
                                     <c:param name="id" value="${faculties.id}"/>
                                     <c:param name="name" value="${faculties.name}"/>
                                     <c:param name="stFundedPlaces" value="${faculties.stFundedPlaces}"/>
                                     <c:param name="totPlaces" value="${faculties.totPlaces}"/>
                                     <c:param name="eieUkLang" value="${faculties.isEieUkLang}"/>
                                     <c:param name="eieMath" value="${faculties.isEieMath}"/>
                                     <c:param name="eiePhysics" value="${faculties.isEiePhysics}"/>
                                     <c:param name="command" value="edit"/>
                                  </c:url>" class="btn btn-info" role="button">edit faculty</a>
                     </td>

                     <c:set var="name" value="${faculties.name}" scope="page"/>
                     <c:if test="${ not empty name and name eq 'add locale name' }">
                         <td><a href="<c:url value='edit_faculty.jsp' >
                                        <c:param name="id" value="${faculties.id}"/>
                                 <%--   <c:param name="name" value="${faculties.name}"/>  --%>
                                        <c:param name="command" value="addLocale"/>
                                     </c:url>" class="btn btn-warning" role="button">add local name</a>
                         </td>

                     </c:if>
                     <td>
                         <form action="list_user" method="GET">
                             <input type="hidden" name="facultyId" value="${faculties.id}" />
                             <input type="hidden" name="command" value="listApplFaculty" />
                             <a href="#" onclick="this.parentNode.submit()" class="btn btn-info" role="button">applicant list</a>
                         </form>
                     </td>
                     <td>
                         <form action="statement" method="POST">
                             <input type="hidden" name="id" value="${faculties.id}" />
                             <input type="hidden" name="name" value="${faculties.name}" />
                             <input type="hidden" name="command" value="ats" />
                             <a href="#" onclick="this.parentNode.submit()" class="btn btn-info" role="button">add to statement</a>
                         </form>
                     </td>
                     <td><a href="<c:url value='/statement' >
                                  <c:param name="id" value="${faculties.id}"/>
                                  <c:param name="name" value="${faculties.name}"/>
                                  <c:param name="com" value="getList"/>
                               </c:url>" class="btn btn-info" role="button">statement list</a>
                     </td>
                     <td><a href="<c:url value='/final_list' >
                                  <c:param name="id" value="${faculties.id}"/>
                               </c:url>" class="btn btn-info" role="button">final list</a>
                     </td>
                </c:if>

                 </tr>
            </c:forEach>
        </table>
        </div>
</body>
</html>
