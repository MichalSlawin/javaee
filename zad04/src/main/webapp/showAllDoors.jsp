<%@ page import="com.javaee.doorstore.domain.Door" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="storage" class="com.javaee.doorstore.service.StorageService" scope="application" />
<%
  for (Door door : storage.getAllDoors()) {
	  out.println("<p>Id: " + door.getId() + "; Production date: " + door.getProductionDate() + "</p>");
	  out.println("<p>Weight: " + door.getWeight() + "; Exterior: " + door.isExterior() + "</p>");
      out.println("<p>Producer: " + door.getProducer() + "; Price: " + door.getPrice() + "</p>");
      out.println("<p>Description: " + door.getDescription() + "</p>");
      out.println("<form action='cart.jsp' method='post'>" +
              "<input name='id' hidden value='" + door.getId() + "' />" +
              "<input type='submit' value=' Add to cart ' />" +
              "</form>");
      out.println();
  }
%>
<p><a href="index.jsp">Menu</a></p>


</body>
</html>