<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="HRServlet" method="post">

<input type="hidden" name="intent" value="update"/>
<input type="hidden" name="id" value="${dept.department_id}"/>

<input type="text" name="deptName" value="${dept.name}"/>
<br>
<input type="submit" value="update"/>

${message}

</form>
</body>
</html>