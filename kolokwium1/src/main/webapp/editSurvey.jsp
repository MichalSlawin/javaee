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
