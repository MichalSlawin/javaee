<%@ page import="com.javaee.doorstore.domain.Door" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cart</title>
</head>
<body>
<jsp:useBean id="storage" class="com.javaee.doorstore.service.StorageService" scope="application" />
<jsp:useBean id="door" class="com.javaee.doorstore.domain.Door" scope="session" />
<jsp:useBean id="cart" class="com.javaee.doorstore.service.StorageService" scope="session" />
<jsp:useBean id="rodo" class="com.javaee.doorstore.domain.Rodo" scope="session" />

<%
    if(!rodo.isPersonalDataConsent() || !rodo.isCookiesConsent()) {
        response.sendRedirect("getRodo.jsp");
    }

    if(request.getParameter("id") != null) {
        long id = Long.parseLong(request.getParameter("id"));

        door = storage.getDoor(id);
        cart.add(door);
    }
    
%>

<p>Doors in cart:</p>

<%
    double priceSum = 0.0;
    for (Door cartDoor : cart.getAllDoors()) {
        out.println("<p>Id: " + cartDoor.getId() + "; Production date: " + cartDoor.getProductionDate() + "</p>");
        out.println("<p>Weight: " + cartDoor.getWeight() + "; Exterior: " + cartDoor.isExterior() + "</p>");
        out.println("<p>Producer: " + cartDoor.getProducer() + "; Price: " + cartDoor.getPrice() + "</p>");
        out.println("<p>Description: " + cartDoor.getDescription() + "</p>");
        out.println("<br />");
        priceSum += cartDoor.getPrice();
    }
    out.println("<br />Total price: " + priceSum);
%>


<p><a href="showAllDoors.jsp">Show all doors</a></p>
<p><a href="index.jsp">Menu</a></p>

</body>
</html>