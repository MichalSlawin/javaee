<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="com.javaee.doorstore.domain.Door" %>
<%@ page import="com.javaee.doorstore.service.StorageService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cart</title>
</head>
<body>
<jsp:useBean id="door" class="com.javaee.doorstore.domain.Door" scope="session" />

<%
    long id = Long.parseLong(request.getParameter("id"));
    door = StorageService.getDoor(id);
%>


<jsp:useBean id="storage" class="com.javaee.doorstore.service.StorageService" scope="session" />

<p>Doors in cart:</p>

<%
    storage.add(door, storage.getShoppingCart());

    for (Door cartDoor : storage.getShoppingCart()) {
        out.println("<p>Id: " + cartDoor.getId() + "; Production date: " + cartDoor.getProductionDate() + "</p>");
        out.println("<p>Weight: " + cartDoor.getWeight() + "; Exterior: " + cartDoor.isExterior() + "</p>");
        out.println("<p>Producer: " + cartDoor.getProducer() + "; Price: " + cartDoor.getPrice() + "</p>");
        out.println("<p>Description: " + cartDoor.getDescription() + "</p>");
        out.println();
    }

%>


<p><a href="showAllDoors.jsp">Show all doors</a></p>
<p><a href="index.jsp">Menu</a></p>

</body>
</html>