<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>

<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Donut Orders</title>
  </head>

    <body>
      <h2><c:out value="${requestScope.name}"/> </h2>
      <h4><c:out value="${requestScope.order}"/> donut(s)</h4>
      <c:if test = "${requestScope.favoriteDonut != null}">
      <h4>Favorite donut: <c:out value="${requestScope.favoriteDonut}"/></h4>
      </c:if>
    </body>

</html>