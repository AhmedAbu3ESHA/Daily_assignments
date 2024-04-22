<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add customer form</title>
</head>
<body>

<form:form action="processgetcustomer"  modelAttribute="TheCustomer">

first name : <form:input    path="firstName"/> <br> 
last name  : <form:input    path="lastName"/><br> 
email      : <form:input    path="email"/><br>

<input type ="submit"  value="Add Customer"><br>
</form:form >


</body>
</html>