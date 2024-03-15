<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>


<%@ page import = "jakarta.servlet.http.*,jakarta.servlet.*" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<form action="servlet-servlet">
    <input type="hidden" name="intent" value="save">
    <label> phone </label>
    <input type="number" name="pho">
    <br>
    <input type="submit" name="intent" value="submit">

</form>
</body>
</html>