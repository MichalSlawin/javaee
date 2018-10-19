<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="door" class="com.example.servletjspdemo.domain.Door" scope="session" />

<jsp:setProperty name="door" property="*" />

<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application" />

<% 
  storage.add(door);
%>

<p>Following door has been added to storage: </p>
<p>First name: ${door.firstName} </p>
<p>Year of birth: <jsp:getProperty name="door" property="yob"></jsp:getProperty></p>
<p>
  <a href="showAllPersons.jsp">Show all persons</a>
</p>
</body>
</html>