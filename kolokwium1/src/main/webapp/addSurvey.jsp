<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Survey added</title>
</head>
<body>

<jsp:useBean id="survey" class="com.javaee.doorstore.domain.Survey" scope="session" />

<%
    Date dateSince = null;
    Date dateTo = null;
    try {
        dateSince = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateSince"));
        dateTo = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateTo"));
    } catch (ParseException e) {
        e.printStackTrace();
    }
    boolean doorTooHeavy = request.getParameter("doorTooHeavy") != null;
    boolean doorWrongColour = request.getParameter("doorWrongColour") != null;
    boolean doorBroken = request.getParameter("doorBroken") != null;
    survey.setDateSince(dateSince);
    survey.setDateTo(dateTo);
    survey.setDoorTooHeavy(doorTooHeavy);
    survey.setDoorWrongColour(doorWrongColour);
    survey.setDoorBroken(doorBroken);
%>

<jsp:setProperty name="survey" property="howOften" param="howOften" />

<jsp:useBean id="storage" class="com.javaee.doorstore.service.StorageService" scope="application" />

<%
    storage.addSurvey(survey);
%>

<p>Survey added to storage</p>
<p><a href="editSurvey.jsp">Edit survey</a></p>
<p><a href="showAllSurveys.jsp">Show all surveys</a></p>
<p><a href="index.jsp">Menu</a></p>

</body>
</html>
