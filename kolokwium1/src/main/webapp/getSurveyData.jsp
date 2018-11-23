<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Survey</title>
</head>
<body>

<jsp:useBean id="survey" class="com.javaee.doorstore.domain.Survey" scope="session" />

<form action="addSurvey.jsp" method="post">

    <%
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateSince = dateFormat.format(new Date());
        String dateTo = dateFormat.format(new Date());

        if(survey.getDateSince() != null) {
            dateSince = dateFormat.format(survey.getDateSince());
            dateTo = dateFormat.format(survey.getDateTo());
        }
        String broken, heavy, colour;
        if(survey.isDoorBroken()) broken = "Is door broken: <input type='checkbox' name='doorBroken' checked /><br />";
        else broken = "Is door broken: <input type='checkbox' name='doorBroken' /><br />";

        if(survey.isDoorTooHeavy()) heavy = "Is door too heavy: <input type='checkbox' name='doorTooHeavy' checked /><br />";
        else heavy = "Is door too heavy: <input type='checkbox' name='doorTooHeavy' /><br />";

        if(survey.isDoorWrongColour()) colour = "Is door wrong colour: <input type='checkbox' name='doorWrongColour' checked /><br />";
        else colour = "Is door wrong colour: <input type='checkbox' name='doorWrongColour' /><br />";

        out.println("Used since: <input type='date'  name='dateSince' value='" + dateSince + "' /><br />\n" +
                "        Used to: <input type='date' name='dateTo' value='" + dateTo + "' /><br />\n" +
                "        <p>How often used:</p>\n" +
                "        <input type='radio' name='howOften' value='Daily' checked> Daily<br />\n" +
                "        <input type='radio' name='howOften' value='Weekly'> Weekly<br />\n" +
                "        <input type='radio' name='howOften' value='Less often'> Less often<br />\n" +
                 broken + heavy + colour + "<input type='submit' value=' OK '>");
    %>

</form>

</body>
</html>
