<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit survey</title>
</head>
<body>

<jsp:useBean id="storage" class="com.javaee.doorstore.service.StorageService" scope="application" />

<%
    long id = Long.parseLong(request.getParameter("id"));
    storage.deleteSurveyById(id);
    response.sendRedirect("showAllSurveys.jsp");
%>

</body>
</html>
