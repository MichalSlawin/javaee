<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 16.11.2018
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Survey</title>
</head>
<body>

<jsp:useBean id="survey" class="com.javaee.doorstore.domain.Survey" scope="session" />

<form action="addSurvey.jsp" method="post">

    Used since: <input type="text"  name="dateSince" value="${survey.dateSince}" /><br />
    Used to: <input type="text" name="dateTo" value="${survey.dateTo}" /><br />
    Is door broken: <input type="checkbox" name="doorBroken" value="${survey.doorBroken}" /><br />
    Is door too heavy: <input type="checkbox" name="doorTooHeavy" value="${survey.doorTooHeavy}" /><br />
    Is door wrong colour: <input type="checkbox" name="doorWrongColour" value="${survey.doorWrongColour}" /><br />
    <input type="submit" value=" OK ">

</form>

</body>
</html>
