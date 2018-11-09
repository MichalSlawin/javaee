<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 09.11.2018
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tmp</title>
</head>
<body>
<jsp:useBean id="rodo" class="com.javaee.doorstore.service.Rodo" scope="session" />

<%
    rodo.setPersonalDataConsent(request.getParameter("personalDataConsent") != null);
    rodo.setCookiesConsent(request.getParameter("cookiesConsent") != null);
    rodo.setKidneyConsent(request.getParameter("kidneyConsent") != null);

    response.sendRedirect("index.jsp");
%>
</body>
</html>
