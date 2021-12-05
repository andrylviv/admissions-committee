<%--
  Created by IntelliJ IDEA.
  User: andry
  Date: 03.11.2021
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>

</head>
<body>
<div align="right">

<c:set var="user" value="${sessionScope.lang}" scope="page"/>
<c:if test="${ empty user }">
    <c:set var="user" value="uk" scope="page"/>
</c:if>
<c:if test="${ not empty user and user eq 'uk' }">
      <form action="lang_ch" method="POST">
          <input type="hidden" name="lang" value="en" />
          <input type="hidden" name="uriVal" value="${pageContext.request.requestURI}" />
          <a class="nav-link" href="#" onclick="this.parentNode.submit()">en</a>
      </form>
  </c:if>

  <c:set var="user" value="${sessionScope.lang}" scope="page"/>
  <c:if test="${ not empty user and user eq 'en' }">
      <form action="lang_ch" method="POST">
          <input type="hidden" name="lang" value="uk" />
          <input type="hidden" name="uriVal" value="${pageContext.request.requestURI}" />
          <a class="nav-link" href="#" onclick="this.parentNode.submit()">uk</a>
      </form>
  </c:if>
</div>
</body>
</html>
