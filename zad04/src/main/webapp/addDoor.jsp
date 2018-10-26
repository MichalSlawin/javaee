<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="door" class="com.javaee.doorstore.domain.Door" scope="session" />

<%--TODO: dodac wlasnosci w setproperty--%>
<%
    Date productionDate = null;
    try {
        productionDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("productionDate"));
    } catch (ParseException e) {
        e.printStackTrace();
    }
    door.setProductionDate(productionDate);
%>
<jsp:setProperty name="door" property="id" param="id" />
<jsp:setProperty name="door" property="weight" param="weight" />
<jsp:setProperty name="door" property="exterior" param="isExterior" />

<jsp:useBean id="storage" class="com.javaee.doorstore.service.StorageService" scope="application" />

<%
  storage.add(door);
%>

<p>Following door has been added to storage: </p>
<p>Id ${door.id} </p>
<p>Production date: ${door.productionDate}</p>
<p>Weight: ${door.weight}</p>
<p>Is exterior: ${door.exterior}</p>
<p>Producer: ${door.producer}</p>
<p>Description: ${door.description}</p>
<p>Price: ${door.price}</p>
<p><a href="showAllDoors.jsp">Show all doors</a></p>
</body>
</html>