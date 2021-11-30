<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 13.11.2021
  Time: 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>ADMIN</title>
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
<div align="right">
    <jsp:include page="langChange.jsp" />
    <%--   <c:set var="user" value="${sessionScope.lang}" scope="page"/>
       <c:if test="${ empty user }">
           <c:set var="user" value="uk" scope="page"/>
       </c:if>
       <c:if test="${ not empty user and user eq 'uk' }">
           <a href="<c:url value='lang_ch' >
                                        <c:param name="lang" value="en"/>
                                        <c:param name="name" value=""/>
                                        <c:param name="uriVal" value="admin_menu.jsp"/>
                                     </c:url>">en</a>
       </c:if>

       <c:set var="user" value="${sessionScope.lang}" scope="page"/>
       <c:if test="${ not empty user and user eq 'en' }">
           <a href="<c:url value='lang_ch' >
                                        <c:param name="lang" value="uk"/>
                                        <c:param name="name" value=""/>
                                        <c:param name="uriVal" value="admin_menu.jsp"/>
                                     </c:url>">uk</a>
       </c:if>--%>
</div>
<h2>Hello ADMIN!</h2>
<a href="<c:url value='/list_user'>
             <c:param name="command" value="lou"/>
         </c:url>">List of applicants</a>
<a href="<c:url value="/list"/>">Faculty List</a>
<a href="<c:url value="/logout"/>"><fmt:message key = "label.logout" bundle = "${lang}"/></a>
</body>
</html>
