<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="rodo" class="com.javaee.doorstore.domain.Rodo" scope="session" />

<%
    if(!rodo.isPersonalDataConsent() || !rodo.isCookiesConsent()) {
        response.sendRedirect("getRodo.jsp");
    }

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <h2>Door store</h2>
        <p><a href="getDoorData.jsp">Add a new door</a></p>
        <p><a href="showAllDoors.jsp">Buy a door</a></p>
        <p><a href="getSurveyData.jsp">Fill a survey</a></p>
    </body>
</html>
