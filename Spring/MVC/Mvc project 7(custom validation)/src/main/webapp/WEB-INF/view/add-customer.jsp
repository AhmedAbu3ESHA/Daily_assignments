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

<form:form action="addCustomerSucsses" modelAttribute="theCustomer">

first name :<form:input path="firstName"/> <form:errors path="firstName"/><br>
last name<form:input path="lastName"/><br><form:errors path="lastName"/><br>
email <form:input path="email"/><br>
age<form:input path="age"/>  <form:errors path="age"/><br>

Active : <form:checkbox path="active"/><br>

gender: <br>

Male:<form:radiobutton path="gender" value="male"/><br>

female:<form:radiobutton path="gender" value="female"/><br>

<input type ="submit"  value="Add Customer"><br>
</form:form >


</body>
</html>