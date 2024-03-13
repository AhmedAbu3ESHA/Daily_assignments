<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">

<tr>
<th> id </th>
<th> name </th>
</tr>
<c:forEach items="${deps}" var="d">
<tr>
<td> ${d.department_id}</td>
<td> ${d.name}</td>
</tr>
</c:forEach>
</table>

</body>
</html>