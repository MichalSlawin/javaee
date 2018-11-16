<%@ page import="com.javaee.doorstore.domain.Survey" %><%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 16.11.2018
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All surveys</title>
</head>
<body>
<jsp:useBean id="storage" class="com.javaee.doorstore.service.StorageService" scope="application" />
<%
    for (Survey survey : storage.getAllSurveys()) {
        out.println("<p>" + survey + "</p>");
    }
%>
<p><a href="index.jsp">Menu</a></p>
</body>
</html>
