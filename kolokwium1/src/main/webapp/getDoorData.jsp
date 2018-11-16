<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New door</title>
</head>
<body>

<jsp:useBean id="storage" class="com.javaee.doorstore.service.StorageService" scope="application" />
<jsp:useBean id="door" class="com.javaee.doorstore.domain.Door" scope="session" />

<form action="addDoor.jsp">

    Id: <input type="text" name="id" value="${door.id}" /><br />
    Production date: <input type="date"  name="productionDate" value="${door.productionDate}" /><br />
    Weight: <input type="text" name="weight" value="${door.weight}" /><br />
    Is exterior: <input type="checkbox" name="isExterior" value="${door.exterior}" /><br />
    Producer: <input type="text" name="producer" value="${door.producer}" /><br />
    Description: <input type="text" name="description" value="${door.description}" /><br />
    Price: <input type="text" name="price" value="${door.price}" /><br />
    <input type="submit" value=" OK ">
  
</form>

</body>
</html>