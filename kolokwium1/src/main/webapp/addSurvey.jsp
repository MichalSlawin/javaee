<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 16.11.2018
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Survey added</title>
</head>
<body>

<jsp:useBean id="survey" class="com.javaee.doorstore.domain.Survey" scope="session" />

<%
    boolean doorTooHeavy = request.getParameter("doorTooHeavy") != null;
    boolean doorWrongColour = request.getParameter("doorWrongColour") != null;
    boolean doorBroken = request.getParameter("doorBroken") != null;
    survey.setDoorTooHeavy(doorTooHeavy);
    survey.setDoorWrongColour(doorWrongColour);
    survey.setDoorBroken(doorBroken);
%>

<jsp:setProperty name="survey" property="dateSince" param="dateSince" />
<jsp:setProperty name="survey" property="dateTo" param="dateTo" />
<jsp:setProperty name="survey" property="howOften" param="howOften" />

<jsp:useBean id="storage" class="com.javaee.doorstore.service.StorageService" scope="application" />

<%
    storage.addSurvey(survey);
%>

<p>Survey added to storage</p>
<p><a href="showAllSurveys.jsp">Show all surveys</a></p>
<p><a href="index.jsp">Menu</a></p>

</body>
</html>
