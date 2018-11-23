<%@ page import="com.javaee.doorstore.domain.Survey" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All surveys</title>
</head>
<body>
<jsp:useBean id="storage" class="com.javaee.doorstore.service.StorageService" scope="application" />
<%
    for (Survey survey : storage.getAllSurveys()) {
        out.print("<p>" + survey + "</p>");
        out.print("<form action='deleteSurvey.jsp' method='post'>" +
                "<input name='id' hidden value='" + survey.getId() + "' />" +
                "<input type='submit' value=' Delete ' />" +
                "</form>");
    }
%>
<p><a href="index.jsp">Menu</a></p>
</body>
</html>
