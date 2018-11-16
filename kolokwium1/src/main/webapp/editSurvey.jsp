<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 16.11.2018
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit survey</title>
</head>
<body>

<jsp:useBean id="storage" class="com.javaee.doorstore.service.StorageService" scope="application" />

<%
    storage.deleteLastSurvey();
    response.sendRedirect("getSurveyData.jsp");
%>

</body>
</html>
