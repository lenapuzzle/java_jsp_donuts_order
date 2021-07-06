<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Donut Orders</title>
  </head>
  <body>
    <h2>Donut Orders</h2>
    <ul>
      <% Map<String, String> donutMessages = (Map) request.getAttribute("donutMessages");%>
      <% Map<String, Integer> donutOrders = (Map) request.getAttribute("donutOrders");
      for(String order : donutOrders.keySet()) {
      %>
       <li><%= order %>: <%= donutOrders.get(order)%> donut(s)
         <p><%=donutMessages.get(order)%></p>
       </li>

       <% } %>
    </ul>
  <p>Order total: <%=request.getAttribute("orderTotal")%></p>
  </body>
</html>